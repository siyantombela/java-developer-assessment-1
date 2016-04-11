package com.assessment.artist.api.resource;

import java.util.List;

import com.assessment.musicbrainz.release.CollaboratingArtist;
import com.assessment.musicbrainz.release.Label;
import com.assessment.musicbrainz.release.ReleaseGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class ArtistRelease {

	private String releaseId;
	private String title;
    private String status;
    private List<Label> labels;
    private int numberOfTracks;
    private List<CollaboratingArtist>otherArtists;
    
    @JsonIgnore
    private ReleaseGroup releaseGroup;
    

   

	public ReleaseGroup getReleaseGroup() {
		return releaseGroup;
	}

	public void setReleaseGroup(ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getReleaseId ()
    {
        return releaseId;
    }

    public void setReleaseId (String releaseId)
    {
        this.releaseId = releaseId;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    

    public int getNumberOfTracks ()
    {
        return numberOfTracks;
    }

    public void setNumberOfTracks (int numberOfTracks)
    {
        this.numberOfTracks = numberOfTracks;
    }

   

    public List<com.assessment.musicbrainz.release.CollaboratingArtist> getOtherArtists() {
		return otherArtists;
	}

	public void setOtherArtists(List<com.assessment.musicbrainz.release.CollaboratingArtist> otherArtists) {
		this.otherArtists = otherArtists;
	}

	

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
	@Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", releaseId = "+releaseId+", status = "+status+", labels = "+labels+", numberOfTracks = "+numberOfTracks+", otherArtists = "+otherArtists+"]";
    }
}
