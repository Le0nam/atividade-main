package com.atividade.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.atividade.model.Fornecedor;
import com.atividade.atividade.repository.IFornecedorRepositorio;

@Service
public class FornecedorServico implements IBaseServicoJPA<Fornecedor>{

    @Autowired
    private IFornecedorRepositorio repo;
    
    public FornecedorServico(IFornecedorRepositorio repo){
        this.repo = repo;
    }

    @Override
    public List<Fornecedor> Browse() {
        return this.repo.findAll(); 
    }

    @Override
    public Optional<Fornecedor> Read(Long chave) {
        return this.repo.findById(chave);
    }

    @Override
    public Fornecedor Edit(Fornecedor obj) {
        Optional<Fornecedor> old = this.repo.findById((long) obj.getCodigo());
        if(old.isPresent()){
            Fornecedor cli = old.get();
            cli.setRazaoSocial(obj.getRazaoSocial());
            cli.setNomeFantasia(obj.getNomeFantasia());
            cli.setCNPJ(obj.getCNPJ());
            cli.setEmail(obj.getEmail());
            cli.setTelefone(obj.getTelefone());
            return cli;
        }
        else
            return null;
    }

    @Override
    public Fornecedor Add(Fornecedor obj) {
        return this.repo.save(obj);
    }

    @Override
    public Fornecedor Delete(Long chave) {
        Optional<Fornecedor> old = this.repo.findById(chave);
        if(old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else
            return null;
    }
    
}
