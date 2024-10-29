package com.atividade.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.atividade.model.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long> {
    
}
