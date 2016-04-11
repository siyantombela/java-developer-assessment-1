package com.assessment.artist.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.artist.entity.Alias;

public interface AliasRepository extends JpaRepository<Alias,Long> {
	Collection<Alias> findByArtistNameStartingWith(String name);
}
