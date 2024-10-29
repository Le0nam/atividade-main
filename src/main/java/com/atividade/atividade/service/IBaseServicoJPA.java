package com.atividade.atividade.service;

import java.util.List;
import java.util.Optional;

public interface IBaseServicoJPA<TModelo> {
    List<TModelo> Browse();
    Optional<TModelo> Read(Long chave);
    TModelo Edit(TModelo obj);
    TModelo Add(TModelo obj);
    TModelo Delete(Long chave);    
}
