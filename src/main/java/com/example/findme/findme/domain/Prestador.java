package com.example.findme.findme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PRESTADOR")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestador")
    private Long id;

    @Column(name = "telefone")
    @NotNull
    private Integer telefone;

    @Column(name = "rg")
    @NotNull
    private Integer email;

    @NotNull
    @Column(name = "cnpj")
    private Integer cnpj;

    @Column(name = "cpf")
    private Integer cpf;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;
}

