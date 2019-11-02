package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.RunTimeExceptionFindMe;
import com.example.findme.findme.domain.Servico;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.repository.ServicoRepository;
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

    private ServicoRepository servicoRepository;

    private UsuarioMapper usuarioMapper;

    @Autowired
    public PrestadorController(
            UsuarioRepository usuarioRepository,
            PrestadorService prestadorService,
            UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.prestadorService = prestadorService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<Prestador> cadastrarUsuario(@RequestBody Prestador prestador, Long idUsuario, Long idServico) {

        Usuario usuarioEncontrado = usuarioRepository.findAllById(idUsuario);

        Servico servicoEncontrado = servicoRepository.findAllById(idServico);

        if (usuarioEncontrado.getId() == null || servicoEncontrado.getId() == null) {
            throw new RunTimeExceptionFindMe();
        }

        Prestador prestadorCadastrado = prestadorService.cadastrarOuAlterarPrestador(prestador, usuarioEncontrado, servicoEncontrado);

        return new ResponseEntity<>(prestadorCadastrado, HttpStatus.CREATED);

    }
}
