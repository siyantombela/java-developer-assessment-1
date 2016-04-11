package com.assessment.artist.service;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.artist.api.resource.ArtistRelease;
import com.assessment.musicbrainz.release.ArtistCredit;
import com.assessment.musicbrainz.release.CollaboratingArtist;
import com.assessment.musicbrainz.release.Label;
import com.assessment.musicbrainz.release.LabelInfo;
import com.assessment.musicbrainz.release.Metadata;
import com.assessment.musicbrainz.release.Releases;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class ArtistService {
	
	private static final Logger log = LoggerFactory.getLogger(ArtistService.class);
	
	public ResponseEntity<Metadata> musicBrainzApi(String artistId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://musicbrainz.org/ws/2/release/?query=arid:"+artistId+"&fmt=json", Metadata.class);	
	}
	
	//Get Releases only marked as Album in release Group primary-type
	public List<ArtistRelease> artistAlbums(String artistId) {
		
		//Get Artists Releases before filtering for Albums only
		List<ArtistRelease> releases = artistReleases(artistId);
		
		
		List<ArtistRelease> albums = new ArrayList<>();
		
		if(!releases.isEmpty()) {

			for (ArtistRelease release : releases) {
				
			
				if (release.getReleaseGroup().getPrimaryType().equalsIgnoreCase("Album")) {
					
					//Limit returned list to just 10 albums
					if (albums.size() < 10) {
						albums.add(release);
					}
						
				}
			}
			
		}
		
		System.out.println("Album Size Before Returning list: " + albums.size());
		
		return albums;
	}
		
	public List<ArtistRelease> artistReleases(String artistId) {
		
		ResponseEntity<Metadata> metadataResponse = musicBrainzApi(artistId);
		
		List<ArtistRelease> formatteredReleases = new ArrayList<ArtistRelease>();
		
		//Only carry on if Musicbrainz API returns status 200
		if(metadataResponse.getStatusCode().is2xxSuccessful()) {
			
			Metadata metadata = metadataResponse.getBody();
			Releases [] releasesObject = metadata.getReleases();
			for (Object object: Arrays.asList(releasesObject)) {
				
				Releases releaseObject = (Releases)object;
				
				ArtistRelease formattedRelease = new ArtistRelease();
				
				formattedRelease.setReleaseId(releaseObject.getReleaseId());
				formattedRelease.setStatus(releaseObject.getStatus());
				formattedRelease.setTitle(releaseObject.getTitle());
				formattedRelease.setNumberOfTracks(releaseObject.getNumberOfTracks());
				formattedRelease.setReleaseGroup(releaseObject.getReleaseGroup());
				
				List<CollaboratingArtist> collaboratingArtists = new ArrayList<>();
				
				//find collaborating artists (That is artists other than the main artist)
				for(Object artistObject : Arrays.asList(releaseObject.getArtistCredit())) {
					ArtistCredit artistCredit = (ArtistCredit)artistObject;
					CollaboratingArtist artist = artistCredit.getArtist();
					
					//Only add 'other' artists to the list of collaborating artists
					if (!artist.getId().equalsIgnoreCase(artistId)) {
						collaboratingArtists.add(artistCredit.getArtist());
					}
		
				}
				
		
				List<Label> labels = new ArrayList<>();
				
				
				//Find Labels to add to Labels list for current release
				if(releaseObject.getLabelInfo() != null) {
					
					for (Object labelInfoObject : Arrays.asList(releaseObject.getLabelInfo())) {
						LabelInfo labelInfo = (LabelInfo)labelInfoObject;		
						labels.add(labelInfo.getLabel());
						
					}	
				}
				
				formattedRelease.setOtherArtists(collaboratingArtists);
				formattedRelease.setLabels(labels);
				formatteredReleases.add(formattedRelease);
				
			}
		
		} else {
			//Would do something else here, but just logging this for now
			log.info("MusicBrainz API returned an error: " + metadataResponse.getStatusCode());
		}
		
		return formatteredReleases;
		
		
	}
}
