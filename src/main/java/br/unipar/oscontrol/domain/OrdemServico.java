/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.oscontrol.domain;

import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class OrdemServico {
    private Cliente cliente;
    private Veiculo veiculo;
    private String descProblemas;
    private ArrayList<Servico> servicos;
    private ArrayList<Peca> pecas;
    private Double valorTotalServicos;
    private Double valorTotalPecas;
    private Double valorTotalOs;

    public OrdemServico(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        
        valorTotalServicos = 0.0;
        valorTotalOs = 0.0;
        valorTotalPecas = 0.0;
    }

    public OrdemServico() {
    }
    
    
    
    public Double calcValorTotalServicos() { 
        valorTotalServicos = 0.0;
        servicos.forEach(s -> {
            valorTotalServicos += s.getValor();
        });
        
        return valorTotalServicos;
    }
    
    public Double calcValorTotalPecas() {   
        valorTotalPecas = 0.0;
        pecas.forEach(p -> {
            valorTotalPecas += p.calcValorTotal();
        });
        
        return valorTotalPecas;
    }
    
    public Double calcValorTotal() {
        valorTotalOs = 0.0;
        valorTotalOs = valorTotalPecas + valorTotalServicos;
        return valorTotalOs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDescProblemas() {
        return descProblemas;
    }

    public void setDescProblemas(String descProblemas) {
        this.descProblemas = descProblemas;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public Double getValorTotalServicos() {
        return valorTotalServicos;
    }

    public void setValorTotalServicos(Double valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
    }

    public Double getValorTotalPecas() {
        return valorTotalPecas;
    }

    public void setValorTotalPecas(Double valorTotalPecas) {
        this.valorTotalPecas = valorTotalPecas;
    }

    public Double getValorTotalOs() {
        return valorTotalOs;
    }

    public void setValorTotalOs(Double valorTotalOs) {
        this.valorTotalOs = valorTotalOs;
    }
    
    
    
}
