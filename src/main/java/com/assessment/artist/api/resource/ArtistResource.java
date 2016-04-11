package com.assessment.artist.api.resource;

import java.util.List;

public class ArtistResource {
	
	private String name;
	private String country;
	private List<String>  alias;
	
	
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
	public List<String> getAlias() {
		return alias;
	}
	public void setAlias(List<String> alias) {
		this.alias = alias;
	}
	

}
