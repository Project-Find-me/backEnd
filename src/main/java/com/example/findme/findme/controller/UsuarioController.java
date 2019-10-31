package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        Usuario usuarios = usuarioService.cadastrarOuAlterarUsuario(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
