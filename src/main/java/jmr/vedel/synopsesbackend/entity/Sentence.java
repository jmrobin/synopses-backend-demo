package jmr.vedel.synopsesbackend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sentence
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	String contents;
	
	Boolean isDraft;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	@OneToMany(mappedBy="sentence1")
	@JsonIgnore
	private List<Triple> triple1;

	@OneToMany(mappedBy="sentence2")
	@JsonIgnore
	private List<Triple> triple2;

	public Sentence(String contents, Author author, Boolean isDraft)
	{
		super();
		this.contents = contents;
		this.author = author;
		this.isDraft = isDraft;
	}
	
	public Sentence()
	{
		this(null, null, null);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public Boolean getIsDraft()
	{
		return isDraft;
	}

	public void setIsDraft(Boolean isDraft)
	{
		this.isDraft = isDraft;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public List<Triple> getTriple1()
	{
		return triple1;
	}

	public void setTriple1(List<Triple> triple1)
	{
		this.triple1 = triple1;
	}

	public List<Triple> getTriple2()
	{
		return triple2;
	}

	public void setTriple2(List<Triple> triple2)
	{
		this.triple2 = triple2;
	}
}
