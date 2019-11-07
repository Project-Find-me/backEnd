package com.example.findme.findme.service.impl;

import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.Servico;
import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.repository.PrestadorRepository;
import com.example.findme.findme.repository.ServicoRepository;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PrestadorServiceImpl implements PrestadorService {

    private final PrestadorRepository prestadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PrestadorServiceImpl(PrestadorRepository prestadorRepository) {
        this.prestadorRepository = prestadorRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Prestador cadastrarOuAlterarPrestador(Prestador prestador) {

        if (prestador.getId() != null) {
            Prestador servicoEncontrado = prestadorRepository.findAllById(prestador.getId());
        }

        Usuario usuario = usuarioRepository.findAllById(prestador.getUsuario().getId());

        prestador.setUsuario(usuario);

        Prestador prestadoSave = prestadorRepository.save(prestador);

        return prestadoSave;
    }
}
