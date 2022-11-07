package com.example.comicweb.model;

import javax.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }
}
