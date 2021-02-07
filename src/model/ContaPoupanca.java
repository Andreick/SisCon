/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author aluno
 */
public class ContaPoupanca extends Banco implements AplicacaoFinanceira {
    
    private int aniversario;
    
    public ContaPoupanca(String nome, String agencia, int numero) {
        this(nome, agencia, numero, 1);
    }
    
    public ContaPoupanca(String nome, String agencia, int numero, int aniversario) {
        super(nome, agencia, numero);
        setAniversario(aniversario);
    }
    
    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        if (aniversario >= 1 && aniversario <= 28) {
            this.aniversario = aniversario;
        }
        else {
            throw new IllegalArgumentException(this.getNome() + ": O aniversário deve ser um número entre 1 e 28.");
        }
    }
    
    @Override
    public void sacar(BigDecimal valor) {
        valor = valor.setScale(2, RoundingMode.HALF_UP);
        if (valor.compareTo(BigDecimal.ZERO) != 1) {
            throw new IllegalArgumentException(this.getNome() + ": O valor do saque deve ser maior que zero.");
        }
        else if (saldo.compareTo(valor) == -1) {
            throw new IllegalArgumentException(this.getNome() + ": Não há saldo suficiente.");
        }
        else {
            saldo = saldo.subtract(valor);
        }
    }
    
    @Override
    public void calcularRendimento(double taxa) {
        calcularRendimento(new BigDecimal(taxa));
    }
    
    @Override
    public void calcularRendimento(BigDecimal taxa) {
        if (taxa.compareTo(BigDecimal.ZERO) == 1) {
            BigDecimal juros = saldo.multiply(taxa);
            this.depositar(juros);
        } else {
            throw new IllegalArgumentException(this.getNome() + ": O rendimento deve ser maior que zero");
        }
    }
    
    @Override
    public String toString() {
        return("------------------------------------------------" +
               "\nBanco: " + getNome() +
               "\nAgência: " + getAgencia() +
               "\nNúmero: " + getNumero() +
               "\nSaldo atual: R$ " + getSaldo() +
               "\nAniversário: " + getAniversario()) +
               "\n------------------------------------------------";
    }
}
