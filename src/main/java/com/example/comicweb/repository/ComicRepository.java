package com.example.comicweb.repository;

import com.example.comicweb.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic,Long> {

    List<Comic> getComicsByCategories(long categoryId);
    List<Comic> getComicByNameContaining(String name);
}
