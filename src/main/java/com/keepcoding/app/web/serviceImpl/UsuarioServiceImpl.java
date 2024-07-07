package com.keepcoding.app.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.app.web.entity.Usuario;
import com.keepcoding.app.web.repository.UsuarioRepository;
import com.keepcoding.app.web.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios(String data) {
        if (data != null && !data.isEmpty()) {
            return usuarioRepository.searchData(data);
        } else {
            return usuarioRepository.findAll();
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setActivo(true); 
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario autenticarCredenciales(String username, String password) {
        List<Usuario> usuarios = usuarioRepository.findByUsernameAndPassword(username, password);
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        }
        return null;
    }
}
