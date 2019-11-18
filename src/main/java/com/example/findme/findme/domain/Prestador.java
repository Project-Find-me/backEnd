package com.example.findme.findme.domain;

import com.example.findme.findme.domain.dto.UsuarioDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_prestador")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestador")
    private Long id;

    @Column(name = "telefone")
    @NotNull
    private BigInteger telefone;

    @Column(name = "rg")
    @NotNull
    private BigInteger rg;

    @Column(name = "cnpj")
    private BigInteger cnpj;

    @Column(name = "cpf")
    private BigInteger cpf;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;
}

