package com.example.comicweb.repository;

import com.example.comicweb.model.ComicChapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersRepository extends JpaRepository<ComicChapters,Long> {

}
