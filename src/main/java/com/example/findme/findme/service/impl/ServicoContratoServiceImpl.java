package com.example.findme.findme.service.impl;

import com.example.findme.findme.domain.*;
import com.example.findme.findme.repository.*;
import com.example.findme.findme.service.ServicoContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ServicoContratoServiceImpl implements ServicoContratoService {


    @Autowired
    private ServicoContratoRepository servicoContratoRepository;

    @Autowired
    private AgendamentoDoServicoRepository agendamentoDoServicoRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ServicoContratado contratoDeServico(@RequestBody ServicoContratado servicoContratado) {


        AgendamentoDeServico agendamentoDeServico = agendamentoDoServicoRepository.save(servicoContratado.getAgendamentoDeServico());

        FormaPagamento formaPagamento = formaPagamentoRepository.save(servicoContratado.getFormaPagamento());

        Usuario usuario = usuarioRepository.findAllById(servicoContratado.getUsuario().getId());

        Prestador prestador = prestadorRepository.findAllById(servicoContratado.getPrestador().getId());

        servicoContratado.setPrestador(prestador);
        servicoContratado.setUsuario(usuario);

        servicoContratoRepository.save(servicoContratado);

        return  servicoContratado;

    }


}
