package com.atividade.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.atividade.model.Pedido;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Long>{

}