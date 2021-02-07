/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.math.BigDecimal;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Despesa;
import model.Teste;

/**
 *
 * @author Andreick
 * //Nelio Alves
 */

public class Principal {
    
    public static void main(String[] args) {
        Carteira ca = new Carteira();
        
        try {
            ca.depositar(300);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            //ca.sacar(200);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        ContaCorrente cc = new ContaCorrente("Banco CC", "123-4", 987654321, new BigDecimal(500));
        
        try {
            cc.depositar(new BigDecimal(1400));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            cc.sacar(new BigDecimal(600));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        ContaPoupanca cp = new ContaPoupanca("Banco CP", "987-6", 123456789);
        
        try {
            cp.depositar(new BigDecimal(8700));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            cp.sacar(new BigDecimal(600));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        /*try {
            cp.calcularRendimento(0.1);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        try {
            ca.transferir(cc, 200);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        
        /*System.out.println("------------------------------------------------");
        System.out.println(ca);
        System.out.println("------------------------------------------------");
        System.out.println(cc);
        System.out.println("------------------------------------------------");
        System.out.println(cp);
        System.out.println("------------------------------------------------");*/
        
        //Conta.listaTodos();
        
        /*System.out.println(ca);
        Despesa desp1 = new Despesa(Date.valueOf("2020-05-12"), "Almoço", 120);
        ca.pagar(desp1);
        System.out.println(desp1);
        Despesa desp2 = new Despesa(Date.valueOf("2020-05-12"), "Janta", 50);
        ca.pagar(desp2);
        System.out.println(desp2);
        System.out.println(ca);*/
        
        //Conta.listaDespesas();
        
        //Teste.testeString();
        
        Teste.testeSet();
    }
}
