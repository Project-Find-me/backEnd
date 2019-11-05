package com.example.findme.findme.service;

import com.example.findme.findme.domain.Usuario;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface UsuarioService {

    Usuario cadastrarOuAlterarUsuario(Usuario usuario) throws IOException;

}
