package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario usuario) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setImagem(usuario.getImagem());

        return usuarioDTO;

    }
}