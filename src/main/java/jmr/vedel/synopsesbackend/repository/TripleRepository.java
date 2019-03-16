package jmr.vedel.synopsesbackend.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jmr.vedel.synopsesbackend.entity.Triple;

@Repository
@Transactional
public class TripleRepository
{
	@Autowired
	EntityManager em;
	
	public List<Triple> getAll()
	{
		TypedQuery<Triple> query = em.createQuery("SELECT t FROM Triple t", Triple.class);
		List<Triple> triples = query.getResultList();
		return triples;
	}
	
	public List<Triple> getNext(Long versionId, Long sentenceId)
	{
		TypedQuery<Triple> query = em.createQuery("SELECT t FROM Triple t", Triple.class);
		List<Triple> triples = query.getResultList();
		List<Triple> nexts = triples
				.stream()
				.filter(t -> t.getVersion1().getId() == versionId)
				.filter(t -> t.getSentence1().getId() == sentenceId)
				.collect(Collectors.toList());
		
		return nexts;
	}
	
	public List<Triple> getNext(Long versionId)
	{
		TypedQuery<Triple> query = em.createQuery("SELECT t FROM Triple t", Triple.class);
		List<Triple> triples = query.getResultList();
		List<Triple> nexts = triples
				.stream()
				.filter(t -> t.getVersion1().getId() == versionId)				
				.collect(Collectors.toList());
		
		return nexts;
	}
	
	public long save(Long sentenceId, Long versionId, Long nextSentenceId, Long nextVersionId)
	{
		String start = "INSERT INTO triple (sentence_id, version_id, next_sentence_id, next_version_id)";
		Query query =
				em
				.createNativeQuery(start + " VALUES (?1, ?2, ?3, ?4)")
				.setParameter(1, sentenceId)
				.setParameter(2, versionId)
				.setParameter(3, nextSentenceId)
				.setParameter(4, nextVersionId);
		query.executeUpdate();
		
		return em
			.createQuery("SELECT t FROM Triple t", Triple.class)
			.getResultList()
			.stream()
			.filter(t -> t.getSentence1().getId() == sentenceId)
			.filter(t -> t.getVersion1().getId() == versionId)
			.filter(t -> t.getSentence2().getId() == nextSentenceId)
			.count();
	}
	
	
}
