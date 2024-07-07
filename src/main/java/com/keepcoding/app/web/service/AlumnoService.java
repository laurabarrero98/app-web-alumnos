package com.keepcoding.app.web.service;

import java.util.List;

import com.keepcoding.app.web.entity.Alumno;

public interface AlumnoService {

	// método que devuelve una lista de alumnos (todos o los que se correspondan con
	// el data)
	public List<Alumno> listarAlumnos(String data);

	// método para guardar a un nuevo alumno
	public Alumno guardarAlumno(Alumno alumno);

	// método para actualizar un alumno
	public Alumno actualizarAlumno(Alumno alumno);

	// Método para eliminar a un alumno por id
	public void eliminarAlumno(Long id);

	// metodo para buscar a un alumno por id
	public Alumno buscarAlumno(Long id);

}
