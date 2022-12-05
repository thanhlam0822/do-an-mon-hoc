package com.example.comicweb.service;

import com.example.comicweb.dto.CategoryListDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService  {
    @Autowired
     private ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryListDTO> getListCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryListDTO> categoryListDTOS = categories.stream().map((category) -> modelMapper.map(category, CategoryListDTO.class))
                .collect(Collectors.toList());
        return categoryListDTOS;
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
