package com.example.comicweb.repository;

import com.example.comicweb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
        List<Category> findCategoriesByIdIn(List<Long> categoryId);
}
