package jmr.vedel.synopsesbackend.service;

import java.util.List;

import jmr.vedel.synopsesbackend.entity.Title;

public interface TitleService
{
	List<Title> getAll();
	Title getById(Long id);
	Title save(Title title);
	Title update(Long id, Title title);
	void delete(Long id);
}
