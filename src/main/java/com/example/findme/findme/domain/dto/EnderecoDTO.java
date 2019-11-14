package com.example.findme.findme.domain.dto;

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
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Identificador do usuário")
    private Long id;

    @ApiModelProperty("Identificador do usuário")
    private BigInteger cep;

    @ApiModelProperty("Identificador do usuário")
    private String cidade;

    @ApiModelProperty("Identificador do usuário")
    private String UF;

    @ApiModelProperty("Identificador do usuário")
    private String rua;

    @ApiModelProperty("Identificador do usuário")
    private String bairro;

    @ApiModelProperty("Identificador do usuário")
    private Integer numero;

    @ApiModelProperty("Identificador do usuário")
    private UsuarioDTO usuario;

}
