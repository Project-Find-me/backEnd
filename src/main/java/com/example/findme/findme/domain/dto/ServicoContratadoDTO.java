package com.example.findme.findme.domain.dto;

import com.example.findme.findme.domain.AgendamentoDeServico;
import com.example.findme.findme.domain.FormaPagamento;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServicoContratadoDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Id do contrato")
    private Long id;

    @ApiModelProperty(notes = "Usuário que contratou o prestador")
    private UsuarioDTO usuario;

    @ApiModelProperty(notes = "O prestador do serviço do contrato")
    private PrestadorDTO prestador;

    @ApiModelProperty(notes = "Agendamento do Serviço do contrato")
    private AgendamentoDeServico agendamentoDeServico;

    @ApiModelProperty(notes = "Forma de pagamento do contrato")
    private FormaPagamento formaPagamento;
}

