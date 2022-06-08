package br.edu.cest;

import br.edu.cest.utils.Fila;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import br.edu.cest.model.Aviao;

/**
 * At-4!
 *
 * – Utilizando os conceitos de fila, escreva um programa que simule o controle de uma pista
 * de decolagem de aviões em um aeroporto. Neste programa, o usuário deve ser capaz de realizar as
 * seguintes tarefas:
 * a) Listar o número de aviões aguardando na fila de decolagem;
 * b) Autorizar a decolagem do primeiro avião da fila;
 * c) Adicionar um avião à fila de espera;
 * d) Listar todos os aviões na fila de espera;
 *
 * */
public class App4
{
    public static void main( String[] args )
    {
        Fila<Aviao> takeOffQueue = new Fila<>();
        Fila<Aviao> waithingQueue = new Fila<>();
        Scanner reader = new Scanner(System.in);
        int LIMIT_PISTA_DECOLAGEM = 3;


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu aviao \n" +
                    "1 - Adicionar Avião a fila de espera \n" +
                    "2 - Autorizar a decolagem \n" +
                    "3 - Listar todos os aviões na fila de espera; \n" +
                    "4 - Listar o número de aviões aguardando na fila de decolagem;" +
                    "5 - SAIR \n");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome/modelo do avião que deverá voar");
                    String nomeAviao = reader.next();

                    if (nomeAviao.equals(null) || nomeAviao.length() == 0) {
                        System.out.println("Digite o nome/modelo válido, para que o avião siga a fila de espera");
                        break;
                    }

                    waithingQueue.inserir(new Aviao(nomeAviao));
                    break;
                case 2:
                    if (waithingQueue.tamanho() == 0) {
                        System.out.println("Não há nenhum avião a espera de decolar! Adicione um avião primeiramente antes de decolar");
                        break;
                    }

                    if(takeOffQueue.estaVazia() && waithingQueue.tamanho() == 1) {
                        Aviao aviao = waithingQueue.remover();
                        System.out.println("O avião "+  aviao.getNome()  +  " se direciona a decolar. Não há fila para decolagem. ");
                        System.out.println("O avião "+  aviao.getNome()  +   " Decolou!!! ");
                        break;
                    }

                    for (int i = waithingQueue.tamanho(); i > 0; i--) {
                        if (takeOffQueue.tamanho() == LIMIT_PISTA_DECOLAGEM) break;
                        takeOffQueue.inserir(waithingQueue.remover());
                    }

                    Aviao aviao = takeOffQueue.remover();
                    System.out.println("O avião "+  aviao.getNome()  +  " se direciona a decolar. Não há fila para decolagem. ");
                    System.out.println("O avião "+  aviao.getNome()  +   " Decolou!!! ");

                    break;
                case 3:
                    System.out.println("Atualmente " + waithingQueue.tamanho() + " aviões na fila de espera");
                    System.out.println("Atualmente os seguintes avioes seguem na fila de espera");
                    waithingQueue.iterar((Aviao a) -> {
                        System.out.println(a.getNome());
                    });
                    break;
                case 4:
                    System.out.println("Atualmente " + takeOffQueue.tamanho() + " aviões na fila de decolagem");

                    if (takeOffQueue.estaVazia()) break;

                    takeOffQueue.iterar((Aviao a) -> {
                        System.out.println("Atualmente os seguintes avioes seguem na fila de decolagem");
                        System.out.println(a.getNome());
                    });
                    break;


                case 5:
                    System.out.println("SAIR");
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }

    }
}
