package jmr.vedel.synopsesbackend.dto;

import java.util.List;

import jmr.vedel.synopsesbackend.entity.Title;

public class VersionDto
{
	private Long id;
	private String description;
	private Long parentVersionId;
	private Boolean isDraft;
	private Title title;
	private AuthorDto author;
	private List<SentenceDto> sentences;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Long getParentVersionId()
	{
		return parentVersionId;
	}
	public void setParentVersionId(Long parentVersionId)
	{
		this.parentVersionId = parentVersionId;
	}
	public Boolean getIsDraft()
	{
		return isDraft;
	}
	public void setIsDraft(Boolean isDraft)
	{
		this.isDraft = isDraft;
	}
	public Title getTitle()
	{
		return title;
	}
	public void setTitle(Title title)
	{
		this.title = title;
	}
	public AuthorDto getAuthor()
	{
		return author;
	}
	public void setAuthor(AuthorDto author)
	{
		this.author = author;
	}
	public List<SentenceDto> getSentences()
	{
		return sentences;
	}
	public void setSentences(List<SentenceDto> sentences)
	{
		this.sentences = sentences;
	}
	
}
