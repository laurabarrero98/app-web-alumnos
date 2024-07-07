package com.keepcoding.app.web.service;

import java.util.List;

import com.keepcoding.app.web.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listarUsuarios(String data);

	public Usuario guardarUsuario(Usuario usuario);

	public Usuario buscarUsuario(Long id);

	public Usuario autenticarCredenciales(String username, String password);
}
