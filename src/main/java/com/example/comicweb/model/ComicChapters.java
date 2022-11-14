package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comic_chapters")
public class ComicChapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private long id;
    @Column(name = "chapter_name")
    private String chapterName;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
    @JoinColumn(name = "comic_id")

    private Comic comic;
    public ComicChapters() {

    }


}
