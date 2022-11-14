package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_id")
    private long id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "view")
    private String view;
    @ManyToMany(mappedBy = "categories")
//    @JoinTable(
//            name = "comic_category",
//            joinColumns = @JoinColumn( name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "comic_id")
//    )
//    @JsonIgnoreProperties("category")

    private List<Comic> comics;


}
