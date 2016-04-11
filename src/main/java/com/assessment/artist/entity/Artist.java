package com.assessment.artist.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@JsonIgnore
	private String uniqueIdentifier;

	private String name,country;
	
	@OneToMany(mappedBy = "artist")
	private Set<Alias> alias = new HashSet<>();
	
	public Set<Alias> getAlias() {
		return alias;
	}

	public void setAlias(Set<Alias> alias) {
		this.alias = alias;
	}

	//For JPA
	protected Artist() {}
	
	public Artist(String name,String country,String uniqueIdentifier) {
		this.name = name;
		this.country = country;
		this.uniqueIdentifier = uniqueIdentifier;
		
	}
	
	@Override
	public String toString() {
		return String.format(
				"Artist[id=%d, name='%s', country='%s',uniqueIdentifier='%s',alias='%s']",
				id,name,country,uniqueIdentifier);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	
}
