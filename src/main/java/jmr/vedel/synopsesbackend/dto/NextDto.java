package jmr.vedel.synopsesbackend.dto;

public class NextDto
{
	private Long nextVersionId;
	private Long nextSentenceId;
	private String nextSentenceContents;
	
	public Long getNextVersionId()
	{
		return nextVersionId;
	}
	public void setNextVersionId(Long nextVersionId)
	{
		this.nextVersionId = nextVersionId;
	}
	public Long getNextSentenceId()
	{
		return nextSentenceId;
	}
	public void setNextSentenceId(Long nextSentenceId)
	{
		this.nextSentenceId = nextSentenceId;
	}
	public String getNextSentenceContents()
	{
		return nextSentenceContents;
	}
	public void setNextSentenceContents(String nextSentenceContents)
	{
		this.nextSentenceContents = nextSentenceContents;
	}
	
}
