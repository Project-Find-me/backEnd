package com.example.findme.findme.repository;

import com.example.findme.findme.domain.ServicoContratado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoContratoRepository extends JpaRepository<ServicoContratado, Long> {
}
