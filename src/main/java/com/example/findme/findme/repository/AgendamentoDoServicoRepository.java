package com.example.findme.findme.repository;

import com.example.findme.findme.domain.AgendamentoDeServico;
import com.example.findme.findme.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoDoServicoRepository extends JpaRepository<AgendamentoDeServico, Long> {


}
