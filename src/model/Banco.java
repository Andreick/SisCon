/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public abstract class Banco extends Conta {
    
    private String agencia;
    private int numero;
    
    public Banco(String nome, String agencia, int numero) {
        super(nome);
        setAgencia(agencia);
        setNumero(numero);
    }
    
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (agencia.length() >= 4) {
            this.agencia = agencia;
        }
        else {
            throw new IllegalArgumentException("A agência deve ter mais de três caracteres.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        }
        else {
            throw new IllegalArgumentException("O número deve ser maior que zero.");
        }
    }
}
