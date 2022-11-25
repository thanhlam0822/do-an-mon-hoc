package com.example.comicweb.dto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String gmail;
    private String job;
    private String position;
}
