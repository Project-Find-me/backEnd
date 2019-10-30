package com.example.findme.findme.config;

import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    // Criar repository spring para Usuario
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // Criar classe de entidade para Usuario
        Usuario usuario = usuarioRepository.findByEmail(login);
        if (usuario != null) {
            return User.withUsername(usuario.getEmail()).password(usuario.getSenha()).roles("CLIENT").build();
        } else {
            throw new UsernameNotFoundException("Não foi possível encontrar o usuário " + login);
        }
    }
}
