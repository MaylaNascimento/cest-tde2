package br.edu.cest;

import br.edu.cest.utils.PilhaUtils;

import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * At-2!
 *
 * Utilizando somente operações de empilhar e desempilhar, escreva um programa que
 * remove um item com chave c fornecida pelo usuário da pilha. Ao final da execução da função, a pilha deve
 * ser igual à original, exceto pela ausência do item removido.
 */
public class App2
{
    public static void main( String[] args )
    {
        Stack<String> mainStack = new Stack<>();
        Scanner reader = new Scanner(System.in);

        System.out.print("Informe uma sequëncia de caracteres separados: ex A base do teto desaba.:\n");
        String userContent = reader.nextLine();

        for (int i = 0; i < userContent.length(); i++) {
            char singleLetter = userContent.charAt(i);
            mainStack.push(String.valueOf(singleLetter));
        }

        String orderAsc = mainStack.stream().collect(Collectors.joining());
        String orderDesc = String.valueOf(new StringBuilder().append(orderAsc).reverse());

        System.out.println(orderAsc);
        System.out.println(orderDesc);

        System.out.println(orderAsc+orderDesc);

    }
}
