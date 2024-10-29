package com.atividade.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.atividade.model.Produto;
import com.atividade.atividade.repository.IProdutoRepositorio;

@Service
public class ProdutoServico implements IBaseServicoJPA<Produto> {

    @Autowired
    private IProdutoRepositorio repo;

    public ProdutoServico(IProdutoRepositorio repo){
        this.repo = repo;
    }

    @Override
    public List<Produto> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Produto> Read(Long chave) {
        return this.repo.findById(chave);
    }

    @Override
    public Produto Edit(Produto obj) {
        Optional<Produto> old = this.repo.findById(obj.getCodigo());
        if (old.isPresent()){
            Produto produto = old.get();
            produto.setNome(obj.getNome());
            produto.setPreco(obj.getPreco());            
            this.repo.save(produto);
            return produto;
        }
        else{
            return null;
        }
    }

    @Override
    public Produto Add(Produto obj) {
        return this.repo.save(obj);
    }

    @Override
    public Produto Delete(Long chave) {
        Optional<Produto> old = this.repo.findById(chave);
        if (old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }
}
