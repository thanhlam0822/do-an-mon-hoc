package com.example.comicweb.dto;

import com.example.comicweb.model.Category;
import com.example.comicweb.model.ComicChapters;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ComicDTO {
    private Long comicId;
    private String author;
    private String description;
    private String imageUrl;
    private String name;
    private String status;
    private Integer view;
    private List<Category> categories;

    private List<ComicChapters> comicChapters;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;
    private Long starRate;

}
