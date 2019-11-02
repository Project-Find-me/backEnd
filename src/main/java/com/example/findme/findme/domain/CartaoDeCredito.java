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
@Table(name = "tb_cartao_de_credito")
public class CartaoDeCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao_pagamento")
    private Long id;

    @NotNull
    @Column(name = "nome_titular")
    private String nomeTitular;

    @NotNull
    @Column(name = "numero_do_cartao")
    private Integer numeroCartao;

    @NotNull
    @Column(name = "validade_do_cartao")
    private String validadeCartao;

    @OneToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;

}
