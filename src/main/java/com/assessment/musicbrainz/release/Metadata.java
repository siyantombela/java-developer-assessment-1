package com.assessment.musicbrainz.release;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
	
	private Releases[] releases;

	public Releases[] getReleases() {
		return releases;
	}

	public void setReleases(Releases[] releases) {
		this.releases = releases;
	}
	
	@Override
    public String toString()
    {
        return "ClassPojo [releases = "+releases+"]";
    }

}
