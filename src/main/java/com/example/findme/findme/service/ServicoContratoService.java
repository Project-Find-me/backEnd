package com.example.findme.findme.service;

import com.example.findme.findme.domain.CartaoDeCredito;
import com.example.findme.findme.domain.ServicoContratado;

import java.util.List;

public interface ServicoContratoService {

    ServicoContratado contratoDeServico(ServicoContratado servicoContratado);

    CartaoDeCredito pagarComCartaoDeCredito(CartaoDeCredito cartaoDeCredito);

    ServicoContratado aceitarContrato(ServicoContratado servicoContratado);

    ServicoContratado pagamentoAceito(ServicoContratado servicoContratado);


}
