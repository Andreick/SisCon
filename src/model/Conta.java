/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public abstract class Conta {
    
    private String nome;
    protected BigDecimal saldo;
    private static ArrayList<Conta> lista = new ArrayList<>();
    private static ArrayList<Despesa> despesas = new ArrayList<>();
    
    public Conta(String nome) {
        setNome(nome);
        saldo = BigDecimal.ZERO;
        adicionaLista();
    }
    
    public void setNome(String nome) {
        if (nome.length() >= 5) {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("O nome deve ter mais de quatro letras.");
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    
    public void depositar(double valor) {
        depositar(new BigDecimal(valor));
    }
    
    public void depositar(BigDecimal valor) {
        valor = valor.setScale(2, RoundingMode.HALF_UP);
        if (valor.compareTo(BigDecimal.ZERO) == 1) {
            saldo = saldo.add(valor);
        }
        else {
            throw new IllegalArgumentException(this.getNome() + ": O valor do depósito deve ser maior que zero.");
        }
    }
    
    public void sacar(double valor) {
        sacar(new BigDecimal(valor));
    }
    
    public abstract void sacar(BigDecimal valor);
    
    /*public void transferir(Conta destino, double valor) {
        transferir(destino, new BigDecimal(valor));
    }*/
    
    public void transferir(Conta destino, BigDecimal valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }
    
    private void adicionaLista() {
        lista.add(this);
    }
    
    public static void adicionaDespesa(Despesa despesa) {
        despesas.add(despesa);
    }
    
    public static void listaDespesas() {
        for (Despesa c: despesas) {
            System.out.println(c);
        }
    }
    
    public static void listaTodos() {
        for (Conta c: lista) {
            System.out.println(c);
        }
    }
}
