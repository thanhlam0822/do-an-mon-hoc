package com.example.comicweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ErrorAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 5000)
    private String errorContent;
    @JsonIgnore
    @ManyToOne
    private ComicChapters comicChapters;
    @JsonIgnore
    @ManyToOne
    private User user;
}
