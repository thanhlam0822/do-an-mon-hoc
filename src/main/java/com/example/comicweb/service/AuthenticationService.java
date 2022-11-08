package com.example.comicweb.service;

import com.example.comicweb.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
