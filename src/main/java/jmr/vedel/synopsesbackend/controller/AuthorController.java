package jmr.vedel.synopsesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmr.vedel.synopsesbackend.entity.Author;
import jmr.vedel.synopsesbackend.service.AuthorService;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins="*")
public class AuthorController
{
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public List<Author> getAll()
	{
		return authorService.getAll();
	}
	
	@GetMapping("/username/{username}")
	public List<Author> getByUsername(@PathVariable String username)
	{
		return authorService.getByUsername(username);
	}
	
	@GetMapping("/{id}")
	public Author getById(@PathVariable Long id)
	{
		return authorService.getById(id);
	}
	
	@PostMapping
	public Author create(@RequestBody Author author)
	{
		return authorService.save(author);
	}
	
	@PutMapping("/{id}")
	public Author update(@PathVariable Long id, @RequestBody Author author)
	{
		return authorService.update(id, author);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		authorService.delete(id);
	}
}
