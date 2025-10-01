package com.vehiculecarepro.repository;

import com.vehiculecarepro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA creará automáticamente la consulta para este método
    // basándose en el nombre: buscará un usuario por su columna "username".
    Optional<User> findByUsername(String username);
}