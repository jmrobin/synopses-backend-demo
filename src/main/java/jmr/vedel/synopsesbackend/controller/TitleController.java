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

import jmr.vedel.synopsesbackend.entity.Title;
import jmr.vedel.synopsesbackend.service.TitleService;

@RestController
@RequestMapping("/titles")
@CrossOrigin(origins="*")
public class TitleController
{
	@Autowired
	TitleService titleService;
	
	@GetMapping
	public List<Title> getAll()
	{
		return titleService.getAll();
	}
	
	@GetMapping("/{id}")
	public Title getById(@PathVariable Long id)
	{
		return titleService.getById(id);
	}
	
	@PostMapping
	public Title create(@RequestBody Title title)
	{
		return titleService.save(title);
	}
	
	@PutMapping("/{id}")
	public Title update(@PathVariable Long id, @RequestBody Title title)
	{
		return titleService.update(id, title);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		titleService.delete(id);
	}
}
