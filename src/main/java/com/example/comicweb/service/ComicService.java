package com.example.comicweb.service;

import com.example.comicweb.dto.ComicDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ComicService {
    List<ComicDTO> getAllComic(Integer pageNumber, Integer pageSize);
    List<Comic> getAllComicByCategory(long categoryId);
    List<ComicDTO> findComicByName(String name);
    Comic findComicById(long comicId);
    void addComic(Comic comic);
    void deleteComic(long comicId);
    List<Comic> findComicByCategoriesName(String name);


}
