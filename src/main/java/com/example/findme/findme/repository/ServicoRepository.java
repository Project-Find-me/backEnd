package com.example.findme.findme.repository;

import com.example.findme.findme.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    Servico findAllById(Long id);

}
