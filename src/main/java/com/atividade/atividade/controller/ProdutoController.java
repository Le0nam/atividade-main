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

import com.atividade.atividade.model.Produto;
import com.atividade.atividade.service.ProdutoServico;

@RestController
@RequestMapping("/api/atividade/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServico servico;

    public ProdutoController(ProdutoServico serv){
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> cp = this.servico.Browse();
        return new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> getById(@PathVariable Long codigo){
        Optional<Produto> opt = this.servico.Read(codigo);
        if (opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto cp) {
        Produto cpnew = this.servico.Add(cp);
        return new ResponseEntity<>(cpnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto cp){
        Produto cpalt = this.servico.Edit(cp);
        if (cpalt != null){
            return new ResponseEntity<>(cpalt, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> delete(@PathVariable Long codigo){
        Produto cpdel = this.servico.Delete(codigo);
        if (cpdel != null){
            return new ResponseEntity<>(cpdel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
