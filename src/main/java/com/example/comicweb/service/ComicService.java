package com.example.comicweb.service;

import com.example.comicweb.model.Comic;

import java.util.List;

public interface ComicService {
    List<Comic> getAllComic();
    List<Comic> getAllComicByCategory(long categoryId);
    List<Comic> findComicByName(String name);
    Comic findComicById(long comicId);
    void addComic(Comic comic);
    void deleteComic(long comicId);

}
