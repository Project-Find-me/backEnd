package com.example.findme.findme.service.impl;

import com.example.findme.findme.domain.Usuario;
import com.example.findme.findme.repository.EnderecoRepository;
import com.example.findme.findme.repository.UsuarioRepository;
import com.example.findme.findme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Usuario cadastrarOuAlterarUsuario(Usuario usuario) throws IOException {

        if (usuario.getId() != null) {

            Usuario usuarioid = usuarioRepository.findAllById(usuario.getId());
        }

        Usuario usuarioCadastrado = usuarioRepository.save(usuario);


        if (usuario.getImagem() != null) {
            String imagem = salvarImagemEmDiretorio(usuario);
            usuario.setImagemDiretorio(imagem);
        }

        if (usuarioCadastrado.getEndereco() != null) {
            this.enderecoRepository.save(usuarioCadastrado.getEndereco());
        }
        return usuarioCadastrado;
    }

    private String salvarImagemEmDiretorio(@RequestBody Usuario usuario) throws IOException {

        String tipo = usuario.getImagem().getType();
        String formatType = tipo.substring(6);
        String imagemString = usuario.getImagem().getBase64();
        String base64Image = imagemString.split(",")[1];

        byte[] btDataFile = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));

        File outputfile = new File("images/avatar"+ usuario.getId()+ "." + formatType);

        FileOutputStream fop = new FileOutputStream(outputfile);

        ImageIO.write(image, formatType, fop);

        return "NiceOOH D";

    }

}
