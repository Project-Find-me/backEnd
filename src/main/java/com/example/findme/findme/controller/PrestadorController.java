package com.example.findme.findme.controller;


import com.example.findme.findme.Exception.MessagesExcpetion.UsuarioNuloException;
import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.ServicoContratado;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.ServicoContratadoDTO;
import com.example.findme.findme.mapper.PrestadorMapper;
import com.example.findme.findme.mapper.ServicoContratoMapper;
import com.example.findme.findme.mapper.UsuarioMapper;
import com.example.findme.findme.repository.PrestadorRepository;
import com.example.findme.findme.repository.ServicoContratoRepository;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.PrestadorService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/prestador")
public class PrestadorController {

    private final UsuarioRepository usuarioRepository;

    private final PrestadorService prestadorService;

    private final PrestadorMapper prestadorMapper;

    private final UsuarioMapper usuarioMapper;

    private final PrestadorRepository prestadorRepository;

    private final ServicoContratoRepository servicoContratoRepository;

    private final ServicoContratoMapper servicoContratoMapper;

    @Autowired
    public PrestadorController(
            UsuarioRepository usuarioRepository,
            PrestadorService prestadorService,
            UsuarioMapper usuarioMapper,
            PrestadorMapper prestadorMapper,
            PrestadorRepository prestadorRepository,
            ServicoContratoRepository servicoContratoRepository,
            ServicoContratoMapper servicoContratoMapper) {
        this.usuarioRepository = usuarioRepository;
        this.prestadorService = prestadorService;
        this.usuarioMapper = usuarioMapper;
        this.prestadorMapper = prestadorMapper;
        this.prestadorRepository = prestadorRepository;
        this.servicoContratoRepository = servicoContratoRepository;
        this.servicoContratoMapper = servicoContratoMapper;
    }

    @PostMapping
    public ResponseEntity<PrestadorDTO> cadastrarPrestador(@RequestBody Prestador prestador) {

        if (prestador.getUsuario().getId() == null) {
            throw new UsuarioNuloException();
        }

        Prestador prestadorCadastrado = prestadorService.cadastrarOuAlterarPrestador(prestador);

        PrestadorDTO prestadorDTO = prestadorMapper.toDto(prestadorCadastrado);

        return new ResponseEntity<>(prestadorDTO, HttpStatus.CREATED);

    }


    @GetMapping("/prestadores-random")
    public ResponseEntity<List<PrestadorDTO>> recuperarAnunciosRandom() {

        List<Prestador> prestador = prestadorRepository.recuperarPrestadorRandom(PageRequest.of(0, 9));

        List<PrestadorDTO> criarDTO = prestadorMapper.toDtoList(prestador);

        return ResponseEntity.ok(criarDTO);
    }

    @GetMapping("/servico/{id}")
    public ResponseEntity<List<PrestadorDTO>> recuperandoIdServicoDoPrestador(@PathVariable("id") Long id) {

        List<Prestador> prestador = prestadorRepository.recuperaIdServico(id);

        if (prestador.size() == 0) {
            prestador = new ArrayList<>();
        }
        List<PrestadorDTO> criarDTO = prestadorMapper.toDtoList(prestador);

        return ResponseEntity.ok(criarDTO);
    }

    @GetMapping("/lista-contratos/{id}")
    public ResponseEntity<List<ServicoContratadoDTO>> listaContratosDoPrestador(@PathVariable("id") Long id) {

        List<ServicoContratado> servicoContratado = servicoContratoRepository.recuperaTodosServicoPrestador(id);

        List<ServicoContratadoDTO> servicoContratadoDTOS = servicoContratoMapper.toDtoList(servicoContratado);

        return new ResponseEntity<>(servicoContratadoDTOS, HttpStatus.FOUND);

    }

    @PutMapping("verificar/usuario/prestador")
    public Boolean verificarSeUsuarioEPrestador(@RequestBody Usuario usuario) {

        Prestador prestador = prestadorRepository.prestadorPorIdUsuario(usuario.getId());

        boolean verificarSePrestadorExiste = false;

        if (prestador != null) {

            verificarSePrestadorExiste = true;

        }

        return verificarSePrestadorExiste;
    }

}

