package com.assessment.musicbrainz.release;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Releases {
	
	@JsonProperty("id")
	private String releaseId;
	
	private String title;
	
	private String status;
	
	@JsonProperty("track-count")
	private int numberOfTracks;
	
	@JsonProperty("artist-credit")
	private ArtistCredit[] artistCredit;
	
	@JsonProperty("label-info")
	private LabelInfo[] labelInfo;
	
	@JsonProperty("release-group")
	private ReleaseGroup releaseGroup;
	
	
	
	public ReleaseGroup getReleaseGroup() {
		return releaseGroup;
	}
	public void setReleaseGroup(ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}
	public ArtistCredit[] getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(ArtistCredit[] artistCredit) {
		this.artistCredit = artistCredit;
	}
	public String getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	
	@Override
	public String toString(){
		return "ClassPojo [releaseId = "+releaseId+", title = "+title+", status = "+status+", numberOfTracks = "+numberOfTracks+"]";
	}
	public LabelInfo[] getLabelInfo() {
		return labelInfo;
	}
	public void setLabelInfo(LabelInfo[] labelInfo) {
		this.labelInfo = labelInfo;
	}
	

}
