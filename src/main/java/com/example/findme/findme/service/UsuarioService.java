package com.example.findme.findme.service;

import com.example.findme.findme.domain.Usuario;
import org.springframework.stereotype.Service;

public interface UsuarioService {

    Usuario cadastrarOuAlterarUsuario(Usuario usuario);

}
