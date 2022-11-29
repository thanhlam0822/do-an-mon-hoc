package com.example.comicweb.repository;

import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic,Long> {

    List<Comic> getComicsByCategories(long categoryId);
    List<Comic> getComicByNameContaining(String name);
    @Query(value = "SELECT   c  FROM Comic c join fetch c.categories ca WHERE   " + "ca.name=:query" +
            " Or c.name   LIKE CONCAT('%',:query, '%')"  +
            "Or c.author LIKE CONCAT('%',:query, '%')" + ""
    )
    List<Comic> searchComics(String query, Pageable pageable);
    @Query( value = "SELECT * from Comic c order by c.view_day desc limit 5  ",nativeQuery = true)
    List<Comic> rankingDay();
    @Query( value = "SELECT * from Comic c order by c.view_week desc limit 5  ",nativeQuery = true)
    List<Comic> rankingWeek();
    @Query( value = "SELECT * from Comic c order by c.view_month desc limit 5  ",nativeQuery = true)
    List<Comic> rankingMonth();
}
