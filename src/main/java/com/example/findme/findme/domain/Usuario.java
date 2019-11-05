package com.example.findme.findme.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.websocket.Decoder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "usuarioseqGen", sequenceName = "seq_usuario", allocationSize = 1)
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioseqGen")
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_completo")
    @NotNull
    private String nome;

    @Column(name = "email")
    @NotNull
    private String email;

    @NotNull
    @Column(name = "senha")
    private String senha;


    @Column(name = "imagem")
    private String imagemDiretorio;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private Endereco endereco;

    @Lob
    @Transient
    private AvatarUsuario imagem;

}

