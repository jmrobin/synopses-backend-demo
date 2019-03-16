package jmr.vedel.synopsesbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmr.vedel.synopsesbackend.dto.AuthorDto;
import jmr.vedel.synopsesbackend.dto.NextDto;
import jmr.vedel.synopsesbackend.dto.SentenceDto;
import jmr.vedel.synopsesbackend.dto.VersionDto;
import jmr.vedel.synopsesbackend.entity.Author;
import jmr.vedel.synopsesbackend.entity.Sentence;
import jmr.vedel.synopsesbackend.entity.Triple;
import jmr.vedel.synopsesbackend.entity.Version;
import jmr.vedel.synopsesbackend.repository.AuthorRepository;
import jmr.vedel.synopsesbackend.repository.SentenceRepository;
import jmr.vedel.synopsesbackend.repository.TripleRepository;
import jmr.vedel.synopsesbackend.repository.VersionRepository;

@Service
public class VersionServiceImpl implements VersionService
{

	@Autowired
	private VersionRepository versionRepository;
	
	@Autowired
	private SentenceRepository sentenceRepository;
	
	@Autowired
	private TripleRepository tripleRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<VersionDto> getAll()
	{
		return versionRepository
				.findAll()
				.stream()
				.map(v -> toVersionDto(v))
				.collect(Collectors.toList());
	}
	
	@Override 
	public List<VersionDto> getPublished()
	{
		return versionRepository
				.findAll()				
				.stream()
				.filter(v -> v.getIsDraft() == false)
				.map(v -> toVersionDto(v))
				.collect(Collectors.toList());
	}
	
	@Override 
	public List<VersionDto> getByAuthorId(Long authorId)
	{
		return versionRepository
				.findAll()				
				.stream()
				.filter(v -> v.getAuthor().getId() == authorId)
				.map(v -> toVersionDto(v))
				.collect(Collectors.toList());
	}

	@Override
	public VersionDto getById(Long id)
	{
		Optional<Version> version = versionRepository.findById(id);
		if(version.isPresent())
		{
			return toVersionDto(version.get());
		}
		return null;
	}

	private VersionDto toVersionDto(Version version)
	{
		VersionDto dto = new VersionDto();
		dto.setId(version.getId());
		dto.setDescription(version.getDescription());		
		dto.setIsDraft(version.getIsDraft());
		dto.setAuthor(toAuthorDto(version.getAuthor()));
		dto.setTitle(version.getTitle());
		dto.setSentences(toSentencesDto(version.getId(), version.getContents()));
		if(version.getParentVersion() != null)
		{
			dto.setParentVersionId(version.getParentVersion().getId());
		}
		else
		{
			dto.setParentVersionId(0L);
		}
		return dto;
	}
	
	private AuthorDto toAuthorDto(Author author)
	{
		AuthorDto dto = new AuthorDto();
		dto.setId(author.getId());
		dto.setUsername(author.getUsername());
		return dto;
	}

	private List<SentenceDto> toSentencesDto(Long versionId, String contents)
	{
		String[] strings = contents.split(":");
		Stream<Long> longs = Stream.of(strings).map(s -> new Long(Long.parseLong(s)));
		return longs
				.map(id -> sentenceRepository.getOne(id))
				.map(s -> toSentenceDto(versionId, s))
				.collect(Collectors.toList());
		
	}
	
	private SentenceDto toSentenceDto(Long versionId, Sentence sentence)
	{
		SentenceDto dto = new SentenceDto();
		dto.setId(sentence.getId());
		dto.setAuthorId(sentence.getAuthor().getId());
		dto.setContents(sentence.getContents());
		dto.setIsDraft(sentence.getIsDraft());
		dto.setNexts(getNextsDto(versionId, sentence.getId()));
		return dto;
	}

	private List<NextDto> getNextsDto(Long versionId, Long sentenceId)
	{
		List<Triple> triples = tripleRepository.getNext(versionId, sentenceId);
		if(triples != null) {
			return triples
					.stream()
					.map(t -> {
						NextDto dto = new NextDto();
						dto.setNextVersionId(t.getVersion2().getId());
						dto.setNextSentenceId(t.getSentence2().getId());
						dto.setNextSentenceContents(t.getSentence2().getContents());
						return dto;
					})
					.collect(Collectors.toList());
		}
		return null;
	}
	
	@Override
	public VersionDto update(Long id, VersionDto versionDto)
	{
		if(versionRepository.existsById(id))
		{
			versionDto.setId(id);
			return save(versionDto);
		}
		return null;
	}
	
	@Override
	public VersionDto save(VersionDto versionDto)
	{
		System.out.println("Saving");
		Version version = new Version();
		if(versionDto.getParentVersionId() == 0)
		{
			version.setParentVersion(null);
		}
		else
		{
			Version parentVersion = versionRepository.getOne(versionDto.getParentVersionId());
			version.setParentVersion(parentVersion);
		}
		version.setDescription(versionDto.getDescription());
		version.setTitle(versionDto.getTitle());
		version.setIsDraft(versionDto.getIsDraft());
		Author author = authorRepository.getOne(versionDto.getAuthor().getId());
		version.setAuthor(author);
		version.setContents(sentencesDtoToContents(versionDto.getSentences()));
		versionRepository.save(version);
		return toVersionDto(version);
	}

	private String sentencesDtoToContents(List<SentenceDto> sentencesDto)
	{
		List<Sentence> sentences = sentencesDto
			.stream()
			.map(dto -> {
				Sentence sentence = new Sentence();
				sentence.setId(dto.getId());
				sentence.setContents(dto.getContents());
				sentence.setIsDraft(dto.getIsDraft());
				Author author = authorRepository.getOne(dto.getAuthorId());
				sentence.setAuthor(author);
				sentenceRepository.save(sentence);				
				return sentence;
			})
			.collect(Collectors.toList());
		return sentences
				.stream()
				.map(s -> s.getId().toString())
				.collect(Collectors.joining(":"));
	}
	
	@Override
	public void delete(Long id)
	{
		Optional<Version> version = versionRepository.findById(id);
		if(version.isPresent())
		{
			String[] strings = version.get().getContents().split(":");
			Stream<Long> longs = Stream.of(strings).map(s -> new Long(Long.parseLong(s)));
			longs
				.map(sentenceId -> sentenceRepository.getOne(sentenceId))
				.filter(s -> s.getIsDraft() == true)
				.forEach(s -> sentenceRepository.delete(s));
			versionRepository.delete(version.get());
		}
	}

}
