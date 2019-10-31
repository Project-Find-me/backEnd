package com.example.findme.findme.service.impl;

import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Usuario cadastrarOuAlterarUsuario(Usuario usuario) {

        if (usuario.getId() != null) {

            Optional<Usuario> usuarioid = usuarioRepository.findById(usuario.getId());

        }
        return usuarioRepository.save(usuario);
    }
}