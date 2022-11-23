package com.example.comicweb.dto;

import com.example.comicweb.model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ComicDTO {
    private Long comicId;
    private String author;
//    private String description;
    private String imageUrl;
    private String name;
//    private String status;
    private Integer view;
    private List<Category> categories;
    private Long starRate;
//    private int viewDay;
//    private int viewWeek;
//    private int viewMonth;
}
