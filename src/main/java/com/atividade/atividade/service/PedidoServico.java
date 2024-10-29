package com.atividade.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.atividade.model.Pedido;
import com.atividade.atividade.repository.IPedidoRepositorio;

@Service
public class PedidoServico implements IBaseServicoJPA<Pedido>{

    @Autowired
    private IPedidoRepositorio repo;

    public PedidoServico(IPedidoRepositorio repo){
        this.repo = repo;
    }

    @Override
    public List<Pedido> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Pedido> Read(Long chave) {
        return this.repo.findById(chave);
    }

    @Override
    public Pedido Edit(Pedido obj) {
        Optional<Pedido> old = this.repo.findById((long) obj.getCodigo());
        if (old.isPresent()){
            Pedido pedido = old.get();
            pedido.setNome(obj.getNome());
            pedido.setCliente(obj.getCliente());
            pedido.setFornecedor(obj.getFornecedor());
            pedido.setProdutos(obj.getProdutos());
            pedido.setDataDeAlteração(obj.getDataDeAlteração());
            this.repo.save(pedido);
            return pedido;
        }
        else
            return null;
        
    }

    @Override
    public Pedido Add(Pedido obj) {
        return this.repo.save(obj);
    }

    @Override
    public Pedido Delete(Long chave) {
        Optional<Pedido> old = this.repo.findById(chave);
        if (old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }
    
}
