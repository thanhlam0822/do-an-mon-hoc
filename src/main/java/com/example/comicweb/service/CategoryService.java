package com.example.comicweb.service;

import com.example.comicweb.dto.CategoryListDTO;
import com.example.comicweb.model.Category;

import java.util.List;

public interface CategoryService {
   List <Category> getAllCategory();
   List<CategoryListDTO> getListCategory();
   Category findCategoryById(long categoryId);
   void addCategory(Category category);
   void deleteById(long categoryId);


}
