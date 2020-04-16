package br.unisinos;

import java.util.Scanner;

public class ArvoreTest {

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma opção: ");
        System.out.println("i - inserir " + "\nb - buscar" + "\nr - remover"
                + "\ne - exibir caminhos Ordem, Pré-ordem e Pós-ordem" + "\nk - sair do programa");
        String opcao = ler.next();
        boolean parada = true;
        while (parada == true) {
            switch (opcao) {

            case "i":
                System.out.println("Digite o número a ser inserido: ");
                int valor = ler.nextInt();
                arvore.inserir(valor);
                parada = true;
                break;

            case "b":
                System.out.println("Digite o número a ser buscado");
                int valor1 = ler.nextInt();
                arvore.buscarPrint(valor1);
                parada = true;
                break;

            case "r":
                System.out.println("Digite o número a ser removido");
                int valor2 = ler.nextInt();
                // metodo remover
                parada = true;
                break;

            case "e":
                arvore.imprimir();
                parada = true;
                break;
           
            case "k":
            	parada = false;
            	break;

            }

            System.out.println("\nDigite a opção: ");
            opcao = ler.next();


        }

    }

}
