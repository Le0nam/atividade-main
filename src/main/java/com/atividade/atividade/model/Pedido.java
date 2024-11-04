package com.atividade.atividade.model;

import java.sql.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ProdutoPedido> produtos;

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    @Column(name = "data_de_inclusao")
    private Date dataDeInclusão;

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    @Column(name = "data_de_alteracao")
    private Date dataDeAlteração;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Set<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

    public Date getDataDeInclusão() {
        return dataDeInclusão;
    }

    public void setDataDeInclusão(Date dataDeInclusão) {
        this.dataDeInclusão = dataDeInclusão;
    }

    public Date getDataDeAlteração() {
        return dataDeAlteração;
    }

    public void setDataDeAlteração(Date dataDeAlteração) {
        this.dataDeAlteração = dataDeAlteração;
    }

    public Pedido() {
    }

    public Pedido(int codigo, String nome, Cliente cliente, Fornecedor fornecedor, Set<ProdutoPedido> produtos,
            Date dataDeInclusão, Date dataDeAlteração) {
        this.codigo = codigo;
        this.nome = nome;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.produtos = produtos;
        this.dataDeInclusão = dataDeInclusão;
        this.dataDeAlteração = dataDeAlteração;
    }

    
}
