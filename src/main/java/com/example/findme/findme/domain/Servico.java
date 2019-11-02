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
@Table(name = "TB_SERVICO")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;

    @NotNull
    @Column(name = "nome_servico")
    private String nomeServico;

    @NotNull
    @Column(name = "preco")
    private Double preco;

}
