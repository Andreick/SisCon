/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Carteira extends Conta implements MeioDePagamento {
    
    public Carteira() {
        this("Carteira");
    }
    
    public Carteira(String nome) {
        super(nome);
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
    
    public void transferir(Conta destino, double valor) {
        transferir(destino, new BigDecimal(valor));
    }
    
    @Override
    public String toString() {
        return ("------------------------------------------------" +
                "\nNome: " + getNome() +
                "\nSaldo atual: R$ " + getSaldo()) +
                "\n------------------------------------------------";
    }
}
