package com.example.comicweb.service;

import com.example.comicweb.model.Comic;
import com.example.comicweb.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComicServiceImpl implements ComicService {
    @Autowired
    ComicRepository comicRepository;
    @Override
    public List<Comic> getAllComic() {
        return comicRepository.findAll();
    }

    @Override
    public List<Comic> getAllComicByCategory(long categoryId) {
        return comicRepository.getComicsByCategories(categoryId);
    }

    @Override
    public List<Comic> findComicByName(String name) {
        return comicRepository.getComicByNameContaining(name);
    }

    @Override
    public Comic findComicById(long comicId) {
        Optional<Comic> list = comicRepository.findById(comicId);
        Comic theComic = list.get();
        return theComic;
    }

    @Override
    public void addComic(Comic comic) {
        comicRepository.save(comic);
    }

    @Override
    public void deleteComic(long comicId) {
        comicRepository.deleteById(comicId);
    }
}
