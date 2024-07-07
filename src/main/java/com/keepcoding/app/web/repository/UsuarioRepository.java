package com.keepcoding.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keepcoding.app.web.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByUsernameAndPassword(String username, String password);
    @Query("SELECT u FROM Usuario u WHERE CONCAT(u.nombre, ' ', u.email, ' ', u.username) LIKE %?1%")
    List<Usuario> searchData(String data);
}

