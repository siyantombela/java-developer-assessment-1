package com.assessment.musicbrainz.release;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollaboratingArtist {
	
	private String id,name;


	public String getId (){
		return id;
	}

	public void setId (String id){
		this.id = id;
	}

	public String getName (){
		return name;
	}

	public void setName (String name){
		this.name = name;
	}


	@Override
	public String toString(){
		
		return "CollaboratingArtist [id = "+id+", name = "+name+"]";
	}
}


