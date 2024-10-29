package com.atividade.atividade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.atividade.model.Fornecedor;
import com.atividade.atividade.service.FornecedorServico;

@RestController
@RequestMapping("/api/atividade/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorServico servico;

    public FornecedorController(FornecedorServico forServico)
    {
        this.servico = forServico;
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll(){
        List<Fornecedor> fornecedores = this.servico.Browse();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long codigo){
        Optional<Fornecedor> cli = this.servico.Read(codigo);
        if(cli.isPresent()){
            return new ResponseEntity<>(cli.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> post(@RequestBody Fornecedor fornecedor){
        Fornecedor newfornecedor = this.servico.Add(fornecedor);
        return new ResponseEntity<>(newfornecedor, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Fornecedor> put(@RequestBody Fornecedor fornecedor){
        Fornecedor cli = this.servico.Edit(fornecedor);
        if(cli != null){
            return new ResponseEntity<>(cli, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Fornecedor> delete(@PathVariable Long codigo){
        Fornecedor fornecedor = this.servico.Delete(codigo);
        if(fornecedor != null){
            return new ResponseEntity<>(fornecedor, HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
