package com.example.comicweb.service;

import com.example.comicweb.model.Category;
import com.example.comicweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService  {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(long categoryId) {
        Optional<Category> list = categoryRepository.findById(categoryId);
        Category theCategory = list.get();
        return  theCategory;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }




}
