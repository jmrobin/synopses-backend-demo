package jmr.vedel.synopsesbackend.service;

import java.util.List;

import jmr.vedel.synopsesbackend.entity.Author;

public interface AuthorService
{
	List<Author> getAll();
	List<Author> getByUsername(String username);
	Author getById(Long id);	
	Author save(Author author);
	Author update(Long id, Author author);
	void delete(Long id);
}
