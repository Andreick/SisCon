package model;

import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Super Dog
 */
public class Teste {
    public static void testeString() {
        String s1 = "java";
        String s2 = "sou";
        String s3 = s2 + " " + s1;
        String s4 = new String("sou java");
        String s5 = "sou java";
        s2 = "java";
        
        System.out.println(s1 == s2);
        System.out.println(s4 == s5);
        System.out.println(s3.equals(s5));
        System.out.println(s3 == s4);
    }
    
    public static void testeSet() {
        Set<String> set = new HashSet();
        
        System.out.println(set.add("Hello"));
        System.out.println(set.add("Hello"));
        //set.remove("Hello");
        
        for(String s : set) {
            System.out.println(s);
        }
        
        System.out.println(set.toString());
    }
}
