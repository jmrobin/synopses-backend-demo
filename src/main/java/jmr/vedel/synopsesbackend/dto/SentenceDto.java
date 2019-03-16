package jmr.vedel.synopsesbackend.dto;

import java.util.List;

public class SentenceDto
{
	private Long id;
	private String contents;
	private Boolean isDraft;
	private Long authorId;
	private List<NextDto> nexts;
	
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
	public Long getAuthorId()
	{
		return authorId;
	}
	public void setAuthorId(Long authorId)
	{
		this.authorId = authorId;
	}
	public List<NextDto> getNexts()
	{
		return nexts;
	}
	public void setNexts(List<NextDto> nexts)
	{
		this.nexts = nexts;
	}
}
