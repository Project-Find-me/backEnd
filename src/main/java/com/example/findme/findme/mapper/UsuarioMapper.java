package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.EnderecoDTO;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PrestadorMapper prestadorMapper;

    public UsuarioDTO toDto(Usuario usuario) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNome(usuario.getNome());

        EnderecoDTO enderecoDTO = enderecoMapper.toDto(usuario.getEndereco());

        Prestador prestador = prestadorRepository.prestadorPorIdUsuario(usuario.getId());

        if (prestador != null) {
            PrestadorDTO prestadorDTO = prestadorMapper.toDto(prestador);
            usuarioDTO.setPrestador(prestadorDTO);
        }

        usuarioDTO.setEndereco(enderecoDTO);
        usuarioDTO.setImagemDiretorio(usuario.getImagemDiretorio());

        return usuarioDTO;

    }
}