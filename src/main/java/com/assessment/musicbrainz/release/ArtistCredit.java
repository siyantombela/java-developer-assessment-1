package com.assessment.musicbrainz.release;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistCredit {
	
	private CollaboratingArtist artist;

	public CollaboratingArtist getArtist() {
		return artist;
	}

	public void setArtist(CollaboratingArtist artist) {
		this.artist = artist;
	}
	
	@Override
    public String toString() {
        return "ClassPojo [artist = "+artist+"]";
    }

}
