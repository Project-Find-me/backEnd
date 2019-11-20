package com.example.findme.findme.repository;

import com.example.findme.findme.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

    FormaPagamento findAllById(Long id);

}
