package com.assessment.artist.api.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.assessment.artist.entity.Alias;
import com.assessment.artist.entity.Artist;

/**
 * 
 * Pagination for a resource result
 *
 * @param <T> results to render 
 */


public class PagedArtistResource<T> {
	
	private Collection<ArtistResource> results;
	private int numberOfSearchResults,page,pageSize,numberOfPages;
	
	
	public PagedArtistResource(Page<T> resultPage, int pageNumberParam,int pageSizeParam) {
		super();
		
	
		@SuppressWarnings("unchecked")
		List<Artist> artists = (List<Artist>) resultPage.getContent();
		
		List<ArtistResource> artistResourceList = new ArrayList<>();
		
		artists.forEach( artist -> {
			
			ArtistResource artistResource = new ArtistResource();
			
			artistResource.setName(artist.getName());
			artistResource.setCountry(artist.getCountry());
			
			//Get set of Aliases for this artist
			Set<Alias> aliasList = artist.getAlias();
			
			//init list 
			List<String> aliases = new ArrayList<>();
			
			aliasList.forEach(alias -> {
				aliases.add(alias.getAlias());
			});
			
			artistResource.setAlias(aliases);	
			artistResourceList.add(artistResource);
			
		});
		
		
		this.setResults(artistResourceList);
		
		numberOfSearchResults = resultPage.getNumberOfElements();
		page = resultPage.getNumber();
		pageSize = resultPage.getSize();
		numberOfPages = resultPage.getTotalPages();
		
	}

	public Collection<ArtistResource> getResults() {
		return results;
	}


	public void setResults(List<ArtistResource> results) {
		this.results = results;
	}


	public int getNumberOfSearchResults() {
		return numberOfSearchResults;
	}


	public void setNumberOfSearchResults(int numberOfSearchResults) {
		this.numberOfSearchResults = numberOfSearchResults;
	}



	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getNumberOfPages() {
		return numberOfPages;
	}


	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	
}
