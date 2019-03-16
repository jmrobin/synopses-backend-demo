package jmr.vedel.synopsesbackend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private Boolean isAdmin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="author")
	@JsonIgnore
	private List<Sentence> sentences;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="author")
	@JsonIgnore
	private List<Version> versions;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Boolean getIsAdmin()
	{
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	public List<Sentence> getSentences()
	{
		return sentences;
	}
	public void setSentences(List<Sentence> sentences)
	{
		this.sentences = sentences;
	}
	public List<Version> getVersions()
	{
		return versions;
	}
	public void setVersions(List<Version> versions)
	{
		this.versions = versions;
	}
	
}
