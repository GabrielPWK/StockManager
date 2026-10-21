package br.com.stockmanager;

import br.com.stockmanager.model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static Produto buscarPorCodigo(List<Produto> lista, String codigo){
        for (Produto p : lista){
            if (p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println("======== Stock Manager ========");

        Scanner sc = new Scanner(System.in);

        List <Produto> lista = new ArrayList<>();
        int opcao;

        do {

            System.out.println("1-Listar");
            System.out.println("2-Cadastrar");
            System.out.println("3-Buscar Código");
            System.out.println("0-Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    if(lista.isEmpty()){
                        System.out.println("Nenhum produto encontrado");
                    }else{
                        for(Produto p : lista){
                            System.out.println(p);
                        }
                    }
                    break;
                case 2:
                {
                    System.out.println("Código do produto:");
                    String codigo = sc.nextLine();

                    if(buscarPorCodigo(lista,codigo)!=null){
                        System.out.println("Já existe um produto com esse código.");
                    }else {
                        System.out.println("Nome do produto:");
                        String nome = sc.nextLine();

                        System.out.println("Categoria do produto:");
                        String categoria = sc.nextLine();

                        System.out.println("Preço de Compra:");
                        BigDecimal precoCompra = new BigDecimal(sc.nextLine());

                        System.out.println("Preço de venda:");
                        BigDecimal precoVenda = new BigDecimal(sc.nextLine());

                        System.out.println("Quantidade do produto:");
                        int quantidade = Integer.parseInt(sc.nextLine());

                        Produto p = new Produto(codigo, nome, categoria, precoCompra, precoVenda, quantidade);
                        lista.add(p);
                    }
                }
                break;
                case 3:
                {
                    System.out.println("Código do produto:");
                    String codigoBuscar = sc.nextLine();

                    Produto buscar = buscarPorCodigo(lista, codigoBuscar);
                    if(buscar == null){
                        System.out.println("Nenhum produto encontrado");
                    } else {
                        System.out.println(buscar);
                    }
                }break;
                case 0:
                    System.out.println("Até Logo!");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }while (opcao!=0);
    }
}