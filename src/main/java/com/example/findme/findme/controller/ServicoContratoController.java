package com.example.findme.findme.controller;


import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.ServicoContratado;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.service.ServicoContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrato/servico")
public class ServicoContratoController {

    @Autowired
    private ServicoContratoService servicoContratoService;

    @PostMapping
    public ResponseEntity<ServicoContratado> cadastrarPrestadorDeServico(@RequestBody ServicoContratado servicoContratado) {

        ServicoContratado servicoCadastro = servicoContratoService.contratoDeServico(servicoContratado);

        return new ResponseEntity<>(servicoCadastro, HttpStatus.CREATED);
    }
}