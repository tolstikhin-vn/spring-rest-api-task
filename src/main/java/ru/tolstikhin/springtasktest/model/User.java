package ru.tolstikhin.springtasktest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surName", nullable = false)
    private String surName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;

    @Column(name = "status", nullable = false)
    private String status;
}
