package com.atividade.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.atividade.model.Cliente;
import com.atividade.atividade.repository.IClienteRepositorio;

@Service
public class ClienteServico implements IBaseServicoJPA<Cliente> {

    @Autowired
    private IClienteRepositorio repo;

    public ClienteServico(IClienteRepositorio repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Cliente> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Cliente> Read(Long chave) {
       return this.repo.findById(chave);
    }

    @Override
    public Cliente Edit(Cliente obj) {
        Optional<Cliente> old = this.repo.findById((long) obj.getCodigo());
        if(old.isPresent()){
            Cliente cli = old.get();
            cli.setNome(obj.getNome());
            cli.setCPF(obj.getCPF());
            cli.setEmail(obj.getEmail());
            cli.setTelefone(obj.getTelefone());
            return cli;
        }
        else
            return null;
    }

    @Override
    public Cliente Add(Cliente obj) {
        return this.repo.save(obj);
    }

    @Override
    public Cliente Delete(Long chave) {
        Optional<Cliente> old = this.repo.findById(chave);
        if(old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else
            return null;
    }   
}