package com.example.findme.findme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_agendamento_de_servico")
public class AgendamentoDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Long id;

    @NotNull
    @Column(name = "data_inicio")
    private String dataInicio;

    @NotNull
    @Column(name = "data_fim")
    private String dataFim;
}
