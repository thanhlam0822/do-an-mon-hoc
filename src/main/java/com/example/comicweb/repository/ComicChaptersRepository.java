package com.example.comicweb.repository;

import com.example.comicweb.model.Comic;
import com.example.comicweb.model.ComicChapters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicChaptersRepository extends JpaRepository<ComicChapters,Long> {
    Page<ComicChapters> getComicChaptersByComic_Id(Long id, Pageable pageable);

}