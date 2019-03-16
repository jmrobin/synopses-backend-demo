package jmr.vedel.synopsesbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmr.vedel.synopsesbackend.dto.TripleDto;
import jmr.vedel.synopsesbackend.service.TripleService;

@RestController
@RequestMapping("/triple")
@CrossOrigin(origins="*")
public class TripleController
{
	@Autowired
	TripleService tripleService;
	
	@PostMapping
	public long next(@RequestBody TripleDto tripleDto)
	{
		return tripleService.save(tripleDto);
	}
}
