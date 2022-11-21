package com.example.comicweb.dto;

import com.example.comicweb.model.Comic;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private String view;
    private List<Comic> comics;


}
