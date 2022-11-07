package com.example.comicweb.restcontroller;

import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import com.example.comicweb.service.CategoryService;
import com.example.comicweb.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ComicService comicService;
    @GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
    @GetMapping("category/{categoryId}")
    public Category findCategoryById(@PathVariable("categoryId") long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }
    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return category;
    }
    @PutMapping("category/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") long categoryId,@RequestBody Category category) {
        category.setId(categoryId);
        categoryService.addCategory(category);
        return category;
    }
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

    @DeleteMapping("category/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteById(categoryId);
        return "DELETE SUCCESSFUL";
    }


}
