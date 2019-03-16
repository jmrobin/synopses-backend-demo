package jmr.vedel.synopsesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jmr.vedel.synopsesbackend.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
	List<Author> findByUsername(String username);
}
