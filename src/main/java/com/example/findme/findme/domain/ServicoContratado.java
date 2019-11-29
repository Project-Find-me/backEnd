package com.example.findme.findme.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_servico_contratado")
public class ServicoContratado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico_contratado")
    private Long id;

    @Column(name = "status_contrato")
    private Boolean statusDeContrato = false;

    @Column(name = "status_pagamento")
    private Boolean statusPagamento = false;

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

