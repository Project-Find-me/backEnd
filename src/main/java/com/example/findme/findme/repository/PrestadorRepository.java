package com.example.findme.findme.repository;

import com.example.findme.findme.domain.Prestador;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    Prestador findAllById(Long id);

    @Query(value = "SELECT p FROM Prestador p ORDER BY NEWID()")
    List<Prestador> recuperarPrestadorRandom(PageRequest pageRequest);

    @Query(value = "Select u from Prestador u where u.servico.id = :id")
    List<Prestador> recuperaIdServico(@Param("id") Long id);
}
