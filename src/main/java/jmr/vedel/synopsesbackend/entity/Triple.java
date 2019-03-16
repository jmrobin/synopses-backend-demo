package jmr.vedel.synopsesbackend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Triple implements Serializable
{
	private static final long serialVersionUID = 6L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="version_id", insertable=false, updatable=false)
	private Version version1;
	
	@Id
	@ManyToOne
	@JoinColumn(name="sentence_id", insertable=false, updatable=false)
	private Sentence sentence1;
	
	@Id
	@ManyToOne
	@JoinColumn(name="next_sentence_id", insertable=false, updatable=false)
	private Sentence sentence2;
		
	@ManyToOne
	@JoinColumn(name="next_version_id")
	private Version version2;

	public Version getVersion1()
	{
		return version1;
	}

	public void setVersion1(Version version1)
	{
		this.version1 = version1;
	}

	public Sentence getSentence1()
	{
		return sentence1;
	}

	public void setSentence1(Sentence sentence1)
	{
		this.sentence1 = sentence1;
	}

	public Sentence getSentence2()
	{
		return sentence2;
	}

	public void setSentence2(Sentence sentence2)
	{
		this.sentence2 = sentence2;
	}

	public Version getVersion2()
	{
		return version2;
	}

	public void setVersion2(Version version2)
	{
		this.version2 = version2;
	}
	
}
