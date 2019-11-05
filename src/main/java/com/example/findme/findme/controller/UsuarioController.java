package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.service.UsuarioService;
import org.hibernate.tool.hbm2ddl.UniqueConstraintSchemaUpdateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) { ;
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody Usuario usuario) throws IOException {

        Usuario usuarios = usuarioService.cadastrarOuAlterarUsuario(usuario);

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuarios);

        return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
    }
}
