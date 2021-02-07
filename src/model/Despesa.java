/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Super Dog
 */
public class Despesa {
    private Date data;
    private String descricao;
    private BigDecimal valor = BigDecimal.ZERO;
    private MeioDePagamento conta;

    public MeioDePagamento getConta() {
        return conta;
    }

    public void setConta(MeioDePagamento conta) {
        this.conta = conta;
    }
    
    public Despesa(Date data, String descricao, double valor) {
        this(data, descricao, new BigDecimal(valor));
    }

    public Despesa(Date data, String descricao, BigDecimal valor) {
        setData(data);
        setDescricao(descricao);
        setValor(valor);
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        Conta ct = (Conta) conta;
        return ("Despesa: " + getData() +
                " " + getDescricao() +
                " R$ " + getValor() +
                " - paga com " + ct.getNome());
    }
}
