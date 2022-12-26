package com.example.comicweb.service;

import com.example.comicweb.dto.ComicChaptersDTO;
import com.example.comicweb.dto.ComicDTO;
import com.example.comicweb.model.Comic;
import com.example.comicweb.model.ComicChapters;
import com.example.comicweb.repository.ComicChaptersRepository;
import com.example.comicweb.repository.ComicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComicChaptersServiceImpl implements ComicChaptersService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ComicRepository comicRepository;
    @Autowired
    ComicChaptersRepository comicChaptersRepository;
    @Override
    public List<ComicChaptersDTO> getAllChapter(Long id,Integer pageNumber, Integer pageSize) {
        Pageable p = PageRequest.of(pageNumber,pageSize);
        Page<ComicChapters> page = comicChaptersRepository.getComicChaptersByComic_Id(id,p);
        List<ComicChapters> comics = page.getContent();
        List<ComicChaptersDTO> comicChaptersDTOS = comics.stream().map((comicChapter) -> modelMapper.map(comicChapter, ComicChaptersDTO.class))
                .collect(Collectors.toList());
        return comicChaptersDTOS;
    }

    @Override
    public ComicChaptersDTO getChapterById(Long id) {
        Optional<ComicChapters> list = comicChaptersRepository.findById(id);
        ComicChapters comicChapters = list.get();
        ComicChaptersDTO comicChaptersDTO = modelMapper.map(comicChapters, ComicChaptersDTO.class);
        return comicChaptersDTO;

    }

    @Override
    public ComicChapters findById(Long id) {
        Optional<ComicChapters> list = comicChaptersRepository.findById(id);
        ComicChapters comicChapters = list.get();
        return comicChapters;
    }

}
