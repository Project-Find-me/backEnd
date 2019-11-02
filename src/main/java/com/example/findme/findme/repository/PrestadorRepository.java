package com.example.findme.findme.repository;

import com.example.findme.findme.domain.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    Prestador findAllById(Long id);

}
