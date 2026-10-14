package br.com.stockmanager;

import br.com.stockmanager.model.Produto;

import java.math.BigDecimal;

public class Main{
    public static void main(String[] args){
        System.out.println("== Stock Manger ==");

        Produto produto = new Produto("L001", "Java Basico","TI", new BigDecimal("49.90"), new BigDecimal("80.50"), 10);
        System.out.println(produto);


    }
}