package com.keepcoding.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.keepcoding.app.web.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	@Query("SELECT a FROM Alumno a WHERE CONCAT(a.nombre, a.apellido, a.telefono, a.dni, a.email) LIKE %?1%")
	public List<Alumno> searchData(@Param("data")String datoBuscado);

}
