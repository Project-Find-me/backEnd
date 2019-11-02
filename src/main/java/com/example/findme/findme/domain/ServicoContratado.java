package com.example.findme.findme.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SERVICO_CONTRATADO")
public class ServicoContratado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico_contratado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_prestador")
    private Prestador prestador;

    @OneToOne
    @JoinColumn(name = "id_agendamento")
    private AgendamentoDeServico agendamentoDeServico;

    @OneToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;
}

