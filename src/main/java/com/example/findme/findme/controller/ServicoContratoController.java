package com.example.findme.findme.controller;


import com.example.findme.findme.domain.CartaoDeCredito;
import com.example.findme.findme.domain.ServicoContratado;
import com.example.findme.findme.domain.dto.ServicoContratadoDTO;
import com.example.findme.findme.mapper.ServicoContratoMapper;
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

    @Autowired
    private ServicoContratoMapper servicoContratoMapper;

    @PostMapping
    public ResponseEntity<ServicoContratadoDTO> cadastrarPrestadorDeServico(@RequestBody ServicoContratado servicoContratado) {

        ServicoContratado servicoCadastro = servicoContratoService.contratoDeServico(servicoContratado);

        ServicoContratadoDTO servicoContratadoDTO = servicoContratoMapper.toDto(servicoCadastro);

        return new ResponseEntity<>(servicoContratadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/pagamento/cartao-de-credito")
    public ResponseEntity<CartaoDeCredito> pagamentoCartaoDeCredito(@RequestBody CartaoDeCredito cartaoDeCredito) {

        CartaoDeCredito cartaoDeCreditoPago = servicoContratoService.pagarComCartaoDeCredito(cartaoDeCredito);

        return new ResponseEntity<>(cartaoDeCreditoPago, HttpStatus.CREATED);

    }
}