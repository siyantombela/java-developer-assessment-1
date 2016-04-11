package com.assessment.artist.controller;



import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.artist.api.resource.ArtistRelease;
import com.assessment.artist.api.resource.PagedArtistResource;
import com.assessment.artist.entity.Artist;
import com.assessment.artist.repository.ArtistRepository;
import com.assessment.artist.service.ArtistService;


@RestController
@RequestMapping("/artist")
public class ArtistRestController {
	
	private final ArtistService artistService;
	private final ArtistRepository artistRepository;
	
	
	@Autowired
	ArtistRestController(ArtistService artistService,ArtistRepository artistRepository) {
		this.artistService = artistService;
		this.artistRepository = artistRepository;
	}
	
	
	@RequestMapping(value="/search/{searchCriteria}/{pageNumber}/{pageSize}", method= RequestMethod.GET)
	public PagedArtistResource<Artist> searchArtist(@PathVariable String searchCriteria,
						@PathVariable int pageNumber,
						@PathVariable int pageSize) {
		
		Pageable pageable = new PageRequest(pageNumber,pageSize);
		Page<Artist> pageResult = this.artistRepository.findByNameStartingWith(searchCriteria,pageable);
		
		PagedArtistResource<Artist> pageableArtists = new PagedArtistResource<Artist>(pageResult,pageNumber,pageSize);
		
		
		
		return pageableArtists;
	}
	
	@RequestMapping(value="/{artistId}/releases",method= RequestMethod.GET)
	public List<ArtistRelease> artistReleases(@PathVariable String artistId) {
		
		List<ArtistRelease> releases = new ArrayList<>();
		//First validate if this artist is in our DB before making API call
		if(validateArtistAgainstDb(artistId)) {	
			releases = artistService.artistReleases(artistId);
		} 
		
		return releases;
				
	}
	
	
	@RequestMapping(value="/{artistId}/albums",method= RequestMethod.GET)
	public List<ArtistRelease> artistAlbums(@PathVariable String artistId) {
		
		List<ArtistRelease> albums = new ArrayList<>();
		
		
		if(validateArtistAgainstDb(artistId)) {	
			albums = artistService.artistAlbums(artistId);	
		} 
		
	
		return albums;
		
	}
	
	
	private boolean validateArtistAgainstDb(String uniqueIdentifier) {		
		return this.artistRepository.findByUniqueIdentifier(uniqueIdentifier) != null;
		
	}

}
