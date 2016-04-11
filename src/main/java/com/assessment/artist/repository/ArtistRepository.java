package com.assessment.artist.repository;

//import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.assessment.artist.entity.Artist;


public interface ArtistRepository extends JpaRepository<Artist, Long> {
	
	//Fetch pageable resultSet for Artists
	Page<Artist> findByNameStartingWith(String name, Pageable pageable);	
	Artist findByUniqueIdentifier(String uniqueIdentifier);

}
