package com.example.findme.findme.repository;

import com.example.findme.findme.domain.Prestador;
import com.example.findme.findme.domain.ServicoContratado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoContratoRepository extends JpaRepository<ServicoContratado, Long> {

    ServicoContratado findAllById(Long id);

    @Query(value = "Select u from ServicoContratado u where u.prestador.id = :id")
    List<ServicoContratado> recuperaTodosServicoPrestador(@Param("id") Long id);


}
