package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrestadorMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    public PrestadorDTO toDto(Prestador prestador) {

        PrestadorDTO prestadorDTO = new PrestadorDTO();

        prestadorDTO.setId(prestador.getId());
        prestadorDTO.setTelefone(prestador.getTelefone());
        prestadorDTO.setRg(prestador.getRg());
        prestadorDTO.setCnpj(prestador.getCnpj());
        prestadorDTO.setCpf(prestador.getCpf());
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(prestador.getUsuario());
        prestadorDTO.setUsuario(usuarioDTO);
        prestadorDTO.setServico(prestador.getServico());

        return prestadorDTO;

    }
}