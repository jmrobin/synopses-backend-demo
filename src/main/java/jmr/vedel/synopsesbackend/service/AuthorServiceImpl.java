package jmr.vedel.synopsesbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmr.vedel.synopsesbackend.entity.Author;
import jmr.vedel.synopsesbackend.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAll()
	{
		return authorRepository.findAll();
	}

	@Override
	public Author getById(Long id)
	{
		return authorRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Author> getByUsername(String username)
	{
		return authorRepository.findByUsername(username);
	}

	@Override
	public Author save(Author author)
	{
		return authorRepository.save(author);
	}

	@Override
	public Author update(Long id, Author author)
	{
		if (authorRepository.existsById(id))
		{
			author.setId(id);
			return save(author);
		}
		return null;
	}

	@Override
	public void delete(Long id)
	{
		authorRepository.findById(id).ifPresent(a -> authorRepository.delete(a));
	}
}
