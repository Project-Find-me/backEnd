package com.example.findme.findme.domain.dto;

import com.example.findme.findme.domain.Endereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Identificador do usuário")
    private Long id;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    @ApiModelProperty(notes = "Email do usuário")
    private String email;

    @ApiModelProperty(notes = "Descricao do email")
    private String imagemDiretorio;

    @ApiModelProperty(notes = "Descricao do email")
    private EnderecoDTO endereco;

    @ApiModelProperty(notes = "Usuario Prestador")
    private PrestadorDTO prestador;
}
