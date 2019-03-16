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

import jmr.vedel.synopsesbackend.dto.VersionDto;
import jmr.vedel.synopsesbackend.service.VersionService;

@RestController
@RequestMapping("/versions")
@CrossOrigin(origins="*")
public class VersionController
{
	@Autowired
	VersionService versionService;
	
	@GetMapping
	public List<VersionDto> getAll()
	{
		return versionService.getAll();
	}
	
	@GetMapping("/published")
	public List<VersionDto> getPublished()
	{
		return versionService.getPublished();
	}
	
	@GetMapping("/{id}")
	public VersionDto getById(@PathVariable Long id)
	{
		return versionService.getById(id);
	}
	
	@GetMapping("/author/{id}")
	public List<VersionDto> getByAuthorId(@PathVariable Long id)
	{
		return versionService.getByAuthorId(id);
	}
	
	@PostMapping
	public VersionDto save(@RequestBody VersionDto versionDto)
	{
		return versionService.save(versionDto);
	}
	
	@PutMapping("/{id}")
	public VersionDto update(@PathVariable Long id, @RequestBody VersionDto versionDto)
	{
		return versionService.update(id, versionDto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		versionService.delete(id);
	}
}
