package com.keepcoding.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keepcoding.app.web.entity.Alumno;
import com.keepcoding.app.web.service.AlumnoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping({ "/", "/alumnos" })
	public String listarAlumnos(Model modelo,
			@RequestParam(value = "datoBuscado", required = false) String datoBuscado) {
		modelo.addAttribute("alumnos", alumnoService.listarAlumnos(datoBuscado));
		modelo.addAttribute("datoBuscado", datoBuscado);
		return "alumno";
	}

	@GetMapping("/alumno/new")
	public String newAlumnoForm(Model modelo) {
		modelo.addAttribute("alumno", new Alumno());
		return "crear_alumno";
	}

	@PostMapping("/alumno")
	public String saveAlumno(@ModelAttribute Alumno alumno,
			@RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
			RedirectAttributes redirectAttributes) {
		if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
				alumno.setFechaNacimiento(date);
			} catch (ParseException e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("errorMessage", "Error al convertir la fecha.");
				return "redirect:/alumno/new";
			}
		}

		alumnoService.guardarAlumno(alumno);

		return "redirect:/alumnos";
	}

	@GetMapping("/alumno/edit/{id}")
	public String editAlumnoForm(@PathVariable Long id, Model modelo) {
		Alumno alumno = alumnoService.buscarAlumno(id);
		if (alumno == null) {
			return "redirect:/alumnos";
		}
		modelo.addAttribute("alumno", alumno);
		return "editar_alumno";
	}

	@PostMapping("/alumno/{id}")
	public String updateAlumno(@PathVariable Long id, @ModelAttribute Alumno alumno,
			@RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
			RedirectAttributes redirectAttributes) {
		Alumno alumnoExistente = alumnoService.buscarAlumno(id);
		if (alumnoExistente != null) {
			if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
					alumnoExistente.setFechaNacimiento(date);
				} catch (ParseException e) {
					e.printStackTrace();
					redirectAttributes.addFlashAttribute("errorMessage", "Error al convertir la fecha.");
					return "redirect:/alumno/edit/" + id;
				}
			}

			alumnoExistente.setNombre(alumno.getNombre());
			alumnoExistente.setApellido(alumno.getApellido());
			alumnoExistente.setDni(alumno.getDni());
			alumnoExistente.setEmail(alumno.getEmail());
			alumnoExistente.setTelefono(alumno.getTelefono());

			alumnoService.actualizarAlumno(alumnoExistente);
		}

		return "redirect:/alumnos";
	}

	@GetMapping("/alumno/delete/{id}")
	public String deleteAlumno(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/alumnos";
	}
}
