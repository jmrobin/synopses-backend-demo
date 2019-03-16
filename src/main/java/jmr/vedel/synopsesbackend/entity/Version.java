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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Version
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String contents;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="title_id")
	private Title title;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	@OneToOne
	@JoinColumn(name="parent_version_id")
	private Version parentVersion;
	
	private Boolean isDraft;
	
	@OneToMany(mappedBy="version1")
	@JsonIgnore
	private List<Triple> triple1;
	
	@OneToMany(mappedBy="version2")
	@JsonIgnore
	private List<Triple> triple2;

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

	public Title getTitle()
	{
		return title;
	}

	public void setTitle(Title title)
	{
		this.title = title;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public Version getParentVersion()
	{
		return parentVersion;
	}

	public void setParentVersion(Version parentVersion)
	{
		this.parentVersion = parentVersion;
	}

	public Boolean getIsDraft()
	{
		return isDraft;
	}

	public void setIsDraft(Boolean isDraft)
	{
		this.isDraft = isDraft;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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
