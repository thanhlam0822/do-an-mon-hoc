package com.example.comicweb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "author")
    private String author;
    @Column(name = "view")
    private int view;
    @Column(name="img_url")
    private String imgageUrl;
    @OneToMany(mappedBy = "comic",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
    private List<ComicChapters> comicChapters;
    @ManyToMany
    @JoinTable(
            name = "comic_category",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;



    public Comic() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public List<ComicChapters> getComicChapters() {
        return comicChapters;
    }

    public void setComicChapters(List<ComicChapters> comicChapters) {
        this.comicChapters = comicChapters;
    }
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getImgageUrl() {
        return imgageUrl;
    }

    public void setImgageUrl(String imgageUrl) {
        this.imgageUrl = imgageUrl;
    }
}
