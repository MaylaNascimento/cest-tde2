package br.edu.cest;


import br.edu.cest.utils.PilhaUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * At-1!
 *
 * - Dado uma pilha que armazene números, escreva uma função que forneça o maior, o menor e a média
 * aritmética dos elementos da pilha.
 */
public class App 
{
    public static void main( String[] args )
    {
        Stack<Integer> numbers = new Stack<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(8);
        numbers.add(9);
        numbers.add(3);
        numbers.add(1);
        numbers.add(7);
        numbers.add(5);

        PilhaUtils<Integer> pilhaUtils = new PilhaUtils<>(numbers);

        System.out.println("O maior valor na pilha: " + pilhaUtils.maior());
        System.out.println("O menor valor na pilha: " + pilhaUtils.menor());
        System.out.println("A media aritimética : " + pilhaUtils.media());

    }
}
