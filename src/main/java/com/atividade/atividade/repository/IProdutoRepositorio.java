package com.atividade.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.atividade.model.Produto;

public interface IProdutoRepositorio extends JpaRepository<Produto, Long>{
    
}
