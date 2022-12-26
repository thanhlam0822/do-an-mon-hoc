package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "comic_chapters")
public class ComicChapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private long id;
    @Column(name = "chapter_name")
    private String chapterName;
    @Column(name = "chapter_link")
    private String chapterLink;
    @Column(name = "chapter_link_eng")
    private String chapterLinkEng;
    @Column(name = "chapter_link_russia")
    private String chapterLinkRussia;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime timeUpdate = LocalDateTime.now();
    @Column
    private int view;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
    @JoinColumn(name = "comic_id")
    @JsonIgnore
    private Comic comic;
    @OneToMany(mappedBy = "comicChapters")
    private List<ErrorAlert> errorAlertList;
    public ComicChapters() {

    }


}
