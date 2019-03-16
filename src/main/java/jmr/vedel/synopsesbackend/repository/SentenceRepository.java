package jmr.vedel.synopsesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jmr.vedel.synopsesbackend.entity.Author;
import jmr.vedel.synopsesbackend.entity.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Long>
{
	List<Sentence> findAllByAuthor(Author author);
}
