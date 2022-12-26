package com.example.comicweb.dto;

import com.example.comicweb.model.Comic;
import com.example.comicweb.model.ComicChapters;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class ComicChaptersDTO {
    private Long id;
    private String name;
    private String link;
    private String linkEng;
    private String linkRussia;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime timeUpdate = LocalDateTime.now();
    private int view;
    private Comic comic;
}
