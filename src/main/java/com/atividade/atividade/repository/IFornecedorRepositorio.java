package com.atividade.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.atividade.model.Fornecedor;

public interface IFornecedorRepositorio extends JpaRepository<Fornecedor, Long> {
    
}
