package com.assessment.musicbrainz.release;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseGroup {
	
	
	private String id;
	@JsonProperty("primary-type")
	private String primaryType;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrimaryType() {
		return primaryType;
	}
	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}
	
	
	/**This is to allow us to identify unique release groups, 
	 * so we don't have 
	 * duplicate Albums
	 * */
	@Override
	 public boolean equals(Object obj) {
		ReleaseGroup other=(ReleaseGroup) obj;
	   return this.id ==other.id;
	 }

	 @Override
	 public int hashCode() {
	    return id.hashCode();
	 }

}
