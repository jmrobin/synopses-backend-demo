package jmr.vedel.synopsesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jmr.vedel.synopsesbackend.entity.Author;
import jmr.vedel.synopsesbackend.entity.Title;
import jmr.vedel.synopsesbackend.entity.Version;

public interface VersionRepository extends JpaRepository<Version, Long>
{
	List<Version> findAllByAuthor(Author author);
	List<Version> findAllByTitle(Title title);
	List<Version> findAllByParentVersion(Version version);
	List<Version> findAllByIsDraft(Boolean isDraft);
}
