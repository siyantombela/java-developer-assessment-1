package com.assessment.artist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Alias {
	
	@Id
	@JsonIgnore
    @GeneratedValue
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Artist artist;
	
	
	private String alias;
	
	//JPA
	Alias() {
	}
	
	public Alias(Artist artist, String alias) {
		this.artist = artist;
		this.alias = alias;
	}
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	

}
