package ru.tolstikhin.springtasktest.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String surName;
    private String email;

    private String imageUrl;

    private String prevStatus;

    private String curStatus;
}
