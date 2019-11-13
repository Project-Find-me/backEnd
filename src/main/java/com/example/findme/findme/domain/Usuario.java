package com.example.findme.findme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank(message = "{name.not.blank}")
    @Column(name = "nome_completo")
    @NotNull
    private String nome;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    @Column(name = "email")
    @NotNull
    private String email;

    @NotBlank(message = "{senha.not.blank}")
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

