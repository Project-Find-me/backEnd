package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.mapper.PrestadorMapper;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.repository.PrestadorRepository;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.PrestadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prestador")
public class PrestadorController {

    private final UsuarioRepository usuarioRepository;

    private final PrestadorService prestadorService;

    private final PrestadorMapper prestadorMapper;

    private final UsuarioMapper usuarioMapper;

    @Autowired
    private PrestadorRepository prestadorRepository;

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


    @GetMapping("/prestadores-random")
    public List<PrestadorDTO> recuperarAnunciosRandom() {

        List<Prestador> prestador = prestadorRepository.recuperarPrestadorRandom(PageRequest.of(0,9));

        List<PrestadorDTO> criarDTO = prestadorMapper.toDtoList(prestador);

        return criarDTO;
    }

}
