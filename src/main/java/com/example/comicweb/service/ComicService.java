package com.example.comicweb.service;

import com.example.comicweb.model.Comic;

import java.util.List;

public interface ComicService {
    List<Comic> getAllComic();
    Comic findComicById(long comicId);
    void addComic(Comic comic);
    void deleteComic(long comicId);
}
