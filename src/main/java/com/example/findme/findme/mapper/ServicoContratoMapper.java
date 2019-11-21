package com.example.findme.findme.mapper;

import com.example.findme.findme.domain.ServicoContratado;
import com.example.findme.findme.domain.dto.PrestadorDTO;
import com.example.findme.findme.domain.dto.ServicoContratadoDTO;
import com.example.findme.findme.domain.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicoContratoMapper {

    @Autowired
    private PrestadorMapper prestadorMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public ServicoContratadoDTO toDto(ServicoContratado servicoContratado) {

        ServicoContratadoDTO servicoContratadoDTO = new ServicoContratadoDTO();

        servicoContratadoDTO.setId(servicoContratado.getId());
        servicoContratadoDTO.setStatusDeContrato(servicoContratado.getStatusDeContrato());

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(servicoContratado.getUsuario());
        servicoContratadoDTO.setUsuario(usuarioDTO);

        PrestadorDTO prestadorDTO = prestadorMapper.toDto(servicoContratado.getPrestador());
        servicoContratadoDTO.setPrestador(prestadorDTO);

        servicoContratadoDTO.setAgendamentoDeServico(servicoContratado.getAgendamentoDeServico());
        servicoContratadoDTO.setFormaPagamento(servicoContratado.getFormaPagamento());

        return servicoContratadoDTO;

    }

    public List<ServicoContratadoDTO> toDtoList(List<ServicoContratado> servicoContratados) {

        List<ServicoContratadoDTO> servicoContratadoDTOArrayList= new ArrayList<>();

        servicoContratados.forEach(servicoContratado -> {
            ServicoContratadoDTO servicoContratadoDTO = new ServicoContratadoDTO();

            servicoContratadoDTO.setId(servicoContratado.getId());
            servicoContratadoDTO.setStatusDeContrato(servicoContratado.getStatusDeContrato());

            UsuarioDTO usuarioDTO = usuarioMapper.toDto(servicoContratado.getUsuario());
            servicoContratadoDTO.setUsuario(usuarioDTO);

            PrestadorDTO prestadorDTO = prestadorMapper.toDto(servicoContratado.getPrestador());
            servicoContratadoDTO.setPrestador(prestadorDTO);

            servicoContratadoDTO.setAgendamentoDeServico(servicoContratado.getAgendamentoDeServico());
            servicoContratadoDTO.setFormaPagamento(servicoContratado.getFormaPagamento());

            servicoContratadoDTOArrayList.add(servicoContratadoDTO);

        });

        return servicoContratadoDTOArrayList;


    }
}