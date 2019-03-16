package jmr.vedel.synopsesbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmr.vedel.synopsesbackend.entity.Title;
import jmr.vedel.synopsesbackend.repository.TitleRepository;

@Service
public class TitleServiceImpl implements TitleService
{
	@Autowired
	TitleRepository titleRepository;

	@Override
	public List<Title> getAll()
	{
		return titleRepository.findAll();
	}

	@Override
	public Title getById(Long id)
	{
		return titleRepository.findById(id).orElse(null);
	}

	@Override
	public Title save(Title title)
	{
		return titleRepository.save(title);
	}
	
	@Override
	public Title update(Long id, Title title)
	{
		if(titleRepository.existsById(id))
		{	title.setId(id);
			return save(title);
		}
		return null;
	}

	@Override
	public void delete(Long id)
	{
		titleRepository.findById(id).ifPresent(t -> titleRepository.delete(t));		
	}
}
