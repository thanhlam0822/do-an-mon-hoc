package com.example.comicweb.service;

import com.example.comicweb.model.ErrorAlert;
import com.example.comicweb.repository.ErrorAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorAlertServiceImpl implements ErrorAlertService {
   @Autowired
   ErrorAlertRepository errorAlertRepository;
    @Override
    public void addErrorAlert(ErrorAlert errorAlert) {
        errorAlertRepository.save(errorAlert);
    }
}
