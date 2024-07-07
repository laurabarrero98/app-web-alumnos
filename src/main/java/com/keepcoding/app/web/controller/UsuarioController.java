package com.keepcoding.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.keepcoding.app.web.entity.Usuario;
import com.keepcoding.app.web.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Mostrar el formulario de login
    @GetMapping("/login")
    public String showLoginForm(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "login";
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Usuario usuario = usuarioService.autenticarCredenciales(username, password);
        if (usuario != null && usuario.isActivo()) {
            return "redirect:/alumnos";
        }
        model.addAttribute("error", "Credenciales inválidas");
        return "login";
    }

    // Mostrar el formulario de registro
    @GetMapping("/crear_usuario")
    public String showRegistrationForm(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "crear_usuario";
    }

    // Procesar el formulario de registro
    @PostMapping("/crear_usuario")
    public String saveUsuario(@ModelAttribute Usuario usuario) {
        usuario.setActivo(true); 
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }
}
