package com.example.findme.findme.controller;


import com.example.findme.findme.domain.ServicoContratado;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.ServicoContratadoDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.mapper.ServicoContratoMapper;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.repository.ServicoContratoRepository;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServicoContratoRepository servicoContratoRepository;

    @Autowired
    private ServicoContratoMapper servicoContratoMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        ;
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid Usuario usuario) throws IOException {

        Usuario usuarios = usuarioService.cadastrarOuAlterarUsuario(usuario);

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuarios);

        return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
    }


    @PostMapping("usuario-logado")
    public UsuarioDTO recuperarUsuarioPormeail(@RequestBody Usuario usuario) {

        Usuario usuarioRecebido = usuarioRepository.findByEmail(usuario.getEmail());

        return usuarioMapper.toDto(usuarioRecebido);

    }

    @GetMapping("/lista-servico-contratados/{id}")
    public ResponseEntity<List<ServicoContratadoDTO>> listaDeServicosContratados(@PathVariable("id") Long id) {

        List<ServicoContratado> servicoContratado = servicoContratoRepository.recuperaTodosServicoUsuario(id);

        List<ServicoContratadoDTO> servicoContratadoDTOS = servicoContratoMapper.toDtoList(servicoContratado);

        return new ResponseEntity<>(servicoContratadoDTOS, HttpStatus.FOUND);

    }
}
