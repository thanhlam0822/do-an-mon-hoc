package com.example.comicweb.service;

import com.example.comicweb.dto.ComicDTO;
import com.example.comicweb.dto.ComicRankingDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
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
public class ComicServiceImpl implements ComicService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ComicRepository comicRepository;
    @Override
    public List<ComicDTO> getAllComic(Integer pageNumber, Integer pageSize) {
        Pageable p = PageRequest.of(pageNumber,pageSize);
        Page<Comic> page = comicRepository.findAll(p);
        List<Comic> comics = page.getContent();
        List<ComicDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
    }

    @Override
    public List<Comic> getAllComicByCategory(long categoryId) {
        return comicRepository.getComicsByCategories(categoryId);
    }

    @Override
    public List<ComicDTO> findComicByName(String name,Integer pageNumber, Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber,pageSize);
        Page<Comic> page =  comicRepository.searchComics(name,p);

        List<Comic> comics = page.getContent();
        List<ComicDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
//        List<Comic> comics = comicRepository.searchComics(name);
//        List<ComicDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicDTO.class))
//                .collect(Collectors.toList());
//        return comicDTOS;
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

    @Override
    public List<ComicRankingDTO> rankingDay() {
        List<Comic> comics = comicRepository.rankingDay();
        List<ComicRankingDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicRankingDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
    }

    @Override
    public List<ComicRankingDTO> rankingWeek() {
        List<Comic> comics = comicRepository.rankingWeek();
        List<ComicRankingDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicRankingDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
    }

    @Override
    public List<ComicRankingDTO> rankingMonth() {
        List<Comic> comics = comicRepository.rankingMonth();
        List<ComicRankingDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicRankingDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
    }

    @Override
    public List<ComicDTO> filterComic(String query1, String query2) {
        List<Comic> comics = comicRepository.filterComic(query1,query2);
        List<ComicDTO> comicDTOS = comics.stream().map((comic) -> modelMapper.map(comic, ComicDTO.class))
                .collect(Collectors.toList());
        return comicDTOS;
    }


}
