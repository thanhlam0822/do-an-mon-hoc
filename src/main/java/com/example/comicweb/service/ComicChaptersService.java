package com.example.comicweb.service;

import com.example.comicweb.dto.ComicChaptersDTO;
import com.example.comicweb.model.Comic;
import com.example.comicweb.model.ComicChapters;

import java.util.List;

public interface ComicChaptersService {
    List<ComicChaptersDTO> getAllChapter(Long id ,Integer pageNumber, Integer pageSize);
    ComicChaptersDTO getChapterById(Long id);
    ComicChapters findById(Long id);
;}
