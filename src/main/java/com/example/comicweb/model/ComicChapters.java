package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
    @JoinColumn(name = "comic_id")
    @JsonIgnore
    private Comic comic;
    public ComicChapters() {

    }


}
