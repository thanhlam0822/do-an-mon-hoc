package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description",length = 100000)
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "author")
    private String author;
    @Column(name = "view")
    private int view;
    @Column(name="img_url")
    private String imgageUrl;
    @JsonIgnore
    @OneToMany(mappedBy = "comic",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
    private List<ComicChapters> comicChapters;
    @OneToMany(mappedBy = "comic",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })
//    @JsonIgnoreProperties("comic")
    @JsonIgnore
    private List<Comment> comments;

    //    @JsonIgnoreProperties("comic")
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "comic_category",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )

    private List<Category> categories;



    public Comic() {

    }


}
