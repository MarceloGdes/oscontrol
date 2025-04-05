/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.oscontrol.domain;

/**
 *
 * @author Marcelo
 */
public class Peca {
    private String nome;
    private Integer qntd;
    private Double valorUn;
    private Double valorTotal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQntd() {
        return qntd;
    }

    public void setQntd(Integer qntd) {
        this.qntd = qntd;
    }

    public Double getValorUn() {
        return valorUn;
    }

    public void setValorUn(Double valorUn) {
        this.valorUn = valorUn;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
