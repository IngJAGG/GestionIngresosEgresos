package com.jagg.pruebaproyecto.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String rol;

    @Column(name = "enterprise")
    private String enterprise;

    @Column(name = "profile")
    private String profile;

    @Column(name = "password")
    private String password;

}