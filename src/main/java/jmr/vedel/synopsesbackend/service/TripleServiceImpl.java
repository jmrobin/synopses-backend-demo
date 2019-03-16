package jmr.vedel.synopsesbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmr.vedel.synopsesbackend.dto.TripleDto;
import jmr.vedel.synopsesbackend.repository.TripleRepository;

@Service
public class TripleServiceImpl implements TripleService
{
	@Autowired
	TripleRepository tripleRepository;
	@Override
	public long save(TripleDto tripleDto)
	{
		return tripleRepository.save(
				tripleDto.getSentenceId(),
				tripleDto.getVersionId(),
				tripleDto.getNextSentenceId(),
				tripleDto.getNextVersionId());
				
	}

}
