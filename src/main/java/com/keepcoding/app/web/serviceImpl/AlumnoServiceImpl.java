package com.keepcoding.app.web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.app.web.entity.Alumno;
import com.keepcoding.app.web.repository.AlumnoRepository;
import com.keepcoding.app.web.service.AlumnoService;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> listarAlumnos(String data) {
		if (data != null && !data.isEmpty()) {
			return alumnoRepository.searchData(data);
		} else {
			return alumnoRepository.findAll();
		}
	}

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public void eliminarAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}

	@Override
	public Alumno buscarAlumno(Long id) {
		return alumnoRepository.findById(id).orElse(null);
	}
}
