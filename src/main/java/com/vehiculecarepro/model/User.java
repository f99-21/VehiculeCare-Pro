package com.vehiculecarepro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_users") // Le damos un nombre explícito a la tabla para evitar conflictos con la palabra reservada "user" en algunas bases de datos.
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Por simplicidad, guardaremos el rol como un String (ej. "ROLE_USER", "ROLE_ADMIN")

    // Constructores, aunque Lombok los puede generar, es bueno tenerlos explícitos a veces.
    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}