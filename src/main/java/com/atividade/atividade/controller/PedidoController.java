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

import com.atividade.atividade.model.Pedido;
import com.atividade.atividade.service.PedidoServico;

@RestController
@RequestMapping("/api/atividade/pedido")
public class PedidoController {

    @Autowired
    private PedidoServico servico;

    public PedidoController(PedidoServico pedidoServico){
        this.servico = pedidoServico;
    }

    @GetMapping
        public ResponseEntity<List<Pedido>> getAll(){
        List<Pedido> pedidoes = this.servico.Browse();
        return new ResponseEntity<>(pedidoes, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getById(@PathVariable Long codigo){
        Optional<Pedido> cli = this.servico.Read(codigo);
        if(cli.isPresent()){
            return new ResponseEntity<>(cli.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody Pedido pedido){
        Pedido newfornecedor = this.servico.Add(pedido);
        return new ResponseEntity<>(newfornecedor, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pedido> put(@RequestBody Pedido fornecedor){
        Pedido cli = this.servico.Edit(fornecedor);
        if(cli != null){
            return new ResponseEntity<>(cli, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Pedido> delete(@PathVariable Long codigo){
        Pedido pedido = this.servico.Delete(codigo);
        if(pedido != null){
            return new ResponseEntity<>(pedido, HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}