package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.mapper.PrestadorMapper;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prestador")
public class PrestadorController {

    private UsuarioRepository usuarioRepository;

    private PrestadorService prestadorService;

    private PrestadorMapper prestadorMapper;

    private UsuarioMapper usuarioMapper;

    @Autowired
    public PrestadorController(
            UsuarioRepository usuarioRepository,
            PrestadorService prestadorService,
            UsuarioMapper usuarioMapper,
            PrestadorMapper prestadorMapper) {
        this.usuarioRepository = usuarioRepository;
        this.prestadorService = prestadorService;
        this.usuarioMapper = usuarioMapper;
        this.prestadorMapper = prestadorMapper;
    }

    @PostMapping
    public ResponseEntity<PrestadorDTO> cadastrarPrestador(@RequestBody Prestador prestador) {


        Prestador prestadorCadastrado = prestadorService.cadastrarOuAlterarPrestador(prestador);

        PrestadorDTO prestadorDTO = prestadorMapper.toDto(prestadorCadastrado);

        return new ResponseEntity<>(prestadorDTO, HttpStatus.CREATED);

    }
}
