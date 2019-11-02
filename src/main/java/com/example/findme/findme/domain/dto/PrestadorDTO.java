package com.example.findme.findme.domain.dto;

import com.example.findme.findme.domain.Servico;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Identificador do usuário")
    private Long id;

    @ApiModelProperty(notes = "Nome do usuário")
    private BigInteger telefone;

    @ApiModelProperty(notes = "Email do usuário")
    private BigInteger rg;

    @ApiModelProperty(notes = "Email do usuário")
    private BigInteger cnpj;

    @ApiModelProperty(notes = "Email do usuário")
    private BigInteger cpf;

    @ApiModelProperty(notes = "Descricao do email")
    private UsuarioDTO usuario;

    @ApiModelProperty(notes = "Descricao do email")
    private Servico servico;

}
