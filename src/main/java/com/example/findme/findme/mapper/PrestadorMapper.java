package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import com.example.findme.findme.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PrestadorDTO> toDtoList(List<Prestador> prestadorList) {

        List<PrestadorDTO> prestadorDTOArray = new ArrayList<>();

        for(int i = 0; i < prestadorList.size(); i++)
        {
            Prestador prestador = new Prestador();
            prestador.setId(prestadorList.get(i).getId());
            prestador.setCnpj(prestadorList.get(i).getCnpj());
            prestador.setCpf(prestadorList.get(i).getCpf());
            prestador.setRg(prestadorList.get(i).getRg());
            prestador.setTelefone(prestadorList.get(i).getTelefone());
            prestador.setServico(prestadorList.get(i).getServico());

            UsuarioDTO usuarioDTO = usuarioMapper.toDto(prestadorList.get(i).getUsuario());

            PrestadorDTO prestadorDTO = new PrestadorDTO();

            prestadorDTO.setId(prestador.getId());
            prestadorDTO.setTelefone(prestador.getTelefone());
            prestadorDTO.setRg(prestador.getRg());
            prestadorDTO.setCnpj(prestador.getCnpj());
            prestadorDTO.setCpf(prestador.getCpf());
            prestadorDTO.setUsuario(usuarioDTO);
            prestadorDTO.setServico(prestador.getServico());

            prestadorDTOArray.add(prestadorDTO);

        }

        return prestadorDTOArray;


    }
}