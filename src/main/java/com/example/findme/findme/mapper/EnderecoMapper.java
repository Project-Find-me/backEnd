package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.Endereco;
import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.dto.EnderecoDTO;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    public EnderecoDTO toDto(Endereco endereco) {

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setUF(endereco.getUF());

        return enderecoDTO;
    }
}