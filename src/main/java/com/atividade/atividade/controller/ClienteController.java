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

import com.atividade.atividade.model.Cliente;
import com.atividade.atividade.service.ClienteServico;

@RestController
@RequestMapping("/api/atividade/cliente")
public class ClienteController {
    @Autowired
    private ClienteServico servico;

    public ClienteController(ClienteServico clienteServico)
    {
        this.servico = clienteServico;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> clientes = this.servico.Browse();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getById(@PathVariable Long codigo){
        Optional<Cliente> cli = this.servico.Read(codigo);
        if(cli.isPresent()){
            return new ResponseEntity<>(cli.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
        Cliente newCliente = this.servico.Add(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> put(@RequestBody Cliente cliente){
        Cliente cli = this.servico.Edit(cliente);
        if(cli != null){
            return new ResponseEntity<>(cli, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Cliente> delete(@PathVariable Long codigo){
        Cliente cliente = this.servico.Delete(codigo);
        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
