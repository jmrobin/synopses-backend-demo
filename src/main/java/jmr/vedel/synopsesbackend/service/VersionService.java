package jmr.vedel.synopsesbackend.service;

import java.util.List;

import jmr.vedel.synopsesbackend.dto.VersionDto;

public interface VersionService
{
	List<VersionDto> getAll();
	List<VersionDto> getPublished();
	List<VersionDto> getByAuthorId(Long authorId);
	VersionDto getById(Long id);
	VersionDto save(VersionDto versionDto);
	VersionDto update(Long id, VersionDto versionDto);
	void delete(Long id);
	
}
