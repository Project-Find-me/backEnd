package com.example.findme.findme.controller;

import com.example.findme.findme.domain.Servico;
import com.example.findme.findme.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/todos-servicos")
    public List<Servico>recuperarTodosOsServicos(){

        List<Servico> list = new ArrayList<Servico>(servicoRepository.findAll());

            return list;
    }
}




