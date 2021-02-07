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
public class ContaCorrente extends Banco implements MeioDePagamento {
    
    private BigDecimal limite;

    public ContaCorrente(String nome, String agencia, int numero) {
        this(nome, agencia, numero, BigDecimal.ZERO);
    }
    
    public ContaCorrente(String nome, String agencia, int numero, double limite) {
        this(nome, agencia, numero, new BigDecimal(limite));
    }
    
    public ContaCorrente(String nome, String agencia, int numero, BigDecimal limite) {
        super(nome, agencia, numero);
        setLimite(limite);
    }
    
    public BigDecimal getLimite() {
        return limite;
    }
    
    public void setLimite(double limite) {
        setLimite(new BigDecimal(limite));
    }

    public void setLimite(BigDecimal limite) {
        limite = limite.setScale(2, RoundingMode.HALF_UP);
        if (limite.compareTo(BigDecimal.ZERO) != -1) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException(this.getNome() + ": O limite não pode ser menor que zero.");
        }
    }
    
    @Override
    public void sacar(BigDecimal valor) {
        valor = valor.setScale(2, RoundingMode.HALF_UP);
        if (valor.compareTo(BigDecimal.ZERO) != 1) {
            throw new IllegalArgumentException(this.getNome() + ": O valor do saque deve ser maior que zero.");
        }
        else if (saldo.add(limite).compareTo(valor) == -1) {
            throw new IllegalArgumentException(this.getNome() + ": Não há saldo suficiente.");
        }
        else {
            saldo = saldo.subtract(valor);
        }
    }
    
    @Override
    public boolean pagar (Despesa despesa) {
        // fazer o pagamento - sacar dinheiro da conta
        try {
            this.sacar(despesa.getValor());
        } catch (RuntimeException ex) {
            return false;
        }
        despesa.setConta(this);
        // registrar a despesa
        Conta.adicionaDespesa(despesa);
        return true;
    }
    
     @Override
    public String toString() {
        return("------------------------------------------------" +
               "\nBanco: " + getNome() +
               "\nAgência: " + getAgencia() +
               "\nNúmero: " + getNumero() +
               "\nSaldo atual: R$ " + getSaldo() +
               "\nLimite: R$ " + getLimite()) +
               "\n------------------------------------------------";
    }
}
