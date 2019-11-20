package com.example.findme.findme.service.impl;

import com.example.findme.findme.Exception.MessagesExcpetion.CartaoDeCreditoFalseExcpetion;
import com.example.findme.findme.Exception.MessagesExcpetion.FormaDePagamentoInexistenteException;
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

    @Autowired
    private CartaoDeCreditoRepository cartaoDeCreditoRepository;


    public ServicoContratado contratoDeServico(@RequestBody ServicoContratado servicoContratado) {


        this.agendamentoDoServicoRepository.save(servicoContratado.getAgendamentoDeServico());

        this.formaPagamentoRepository.save(servicoContratado.getFormaPagamento());

        Usuario usuario = usuarioRepository.findAllById(servicoContratado.getUsuario().getId());

        Prestador prestador = prestadorRepository.findAllById(servicoContratado.getPrestador().getId());

        servicoContratado.setPrestador(prestador);
        servicoContratado.setUsuario(usuario);

        servicoContratoRepository.save(servicoContratado);

        return  servicoContratado;

    }

    public CartaoDeCredito pagarComCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {

        if (cartaoDeCredito.getFormaPagamento().getId() == null) {
            throw new FormaDePagamentoInexistenteException();
        }

        FormaPagamento formaPagamento = formaPagamentoRepository.findAllById(cartaoDeCredito.getFormaPagamento().getId());

        if (!formaPagamento.getCartaoDeCredito()) {
            throw new CartaoDeCreditoFalseExcpetion();
        }

        cartaoDeCredito.setFormaPagamento(formaPagamento);

        this.cartaoDeCreditoRepository.save(cartaoDeCredito);

        return cartaoDeCredito;
    }


}
