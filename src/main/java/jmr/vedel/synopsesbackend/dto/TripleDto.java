package jmr.vedel.synopsesbackend.dto;

public class TripleDto
{
	private Long sentenceId;
	private Long versionId;
	private Long nextSentenceId;
	private Long nextVersionId;
	
	public Long getSentenceId()
	{
		return sentenceId;
	}
	public void setSentenceId(Long sentenceId)
	{
		this.sentenceId = sentenceId;
	}
	public Long getVersionId()
	{
		return versionId;
	}
	public void setVersionId(Long versionId)
	{
		this.versionId = versionId;
	}
	public Long getNextSentenceId()
	{
		return nextSentenceId;
	}
	public void setNextSentenceId(Long nextSentenceId)
	{
		this.nextSentenceId = nextSentenceId;
	}
	public Long getNextVersionId()
	{
		return nextVersionId;
	}
	public void setNextVersionId(Long nextVersionId)
	{
		this.nextVersionId = nextVersionId;
	}
}
