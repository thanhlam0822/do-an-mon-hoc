package com.example.comicweb.dto;

import com.example.comicweb.model.Category;
import lombok.Data;

import java.util.List;
@Data
public class ComicRankingDTO {
    private Long comicId;
    private String name;
    private String imageUrl;
    private int viewDay;
    private int viewWeek;
    private int viewMonth;
}
