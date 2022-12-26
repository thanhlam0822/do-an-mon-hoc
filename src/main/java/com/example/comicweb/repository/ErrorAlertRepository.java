package com.example.comicweb.repository;

import com.example.comicweb.model.ErrorAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorAlertRepository extends JpaRepository<ErrorAlert, Long> {
}
