package com.example.comicweb.restcontroller;

import com.example.comicweb.dto.CategoryDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import com.example.comicweb.service.CategoryService;
import com.example.comicweb.service.ComicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ComicService comicService;
    // Lấy mọi danh mục của Category
    @GetMapping("/category")
    public List<CategoryDTO> getAllCategory() {

        return categoryService.getAllCategory().stream().map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }


    // Lấy mọi danh mục Category theo Id
    @GetMapping("category/{categoryId}")
    public Category findCategoryById(@PathVariable("categoryId") long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }


    // Thêm một danh mục vào Category
    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return category;
    }
    // Chinh sua category bang cach truyen Id vao path varible
    @PutMapping("category/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") long categoryId,@RequestBody Category category) {
        category.setId(categoryId);
        categoryService.addCategory(category);
        return category;
    }
    // Them Category cho tung truyen
    @PutMapping("/category/{categoryId}/{comicId}")
    public Comic updateComicCategory(@PathVariable("categoryId") long categoryId,@PathVariable("comicId") long comicId) throws Exception {
        Category category = categoryService.findCategoryById(categoryId);
        Comic comic  = comicService.findComicById(comicId);
        List<Category> categoryList = comic.getCategories();
        categoryList.add(category);
        comic.setCategories(categoryList);
        comicService.addComic(comic);
        return comic;

    }
    // Xoa category bang id cua category
    @DeleteMapping("category/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteById(categoryId);
        return "DELETE SUCCESSFUL";
    }


}
