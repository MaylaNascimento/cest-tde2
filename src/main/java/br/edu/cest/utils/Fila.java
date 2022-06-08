package br.edu.cest.utils;

import java.util.function.Consumer;
import java.util.function.Function;

public class Fila<T> implements IFila<T> {
    private Node first; // mais recente
    private Node last;  // mais antigo
    private int N;

    private class Node {
        private T item;
        private Node next;
    }

    public boolean estaVazia() {
        return first == null;
    }

    public int tamanho() {
        return N;
    }

    public void inserir(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (estaVazia()) first = last;
        else oldlast.next = last;
        N++;
    }

    public T remover() {
        T item = first.item;
        first = first.next;
        N--;
        if (estaVazia()) last = null;
        return item;
    }

    public void iterar(Consumer<T> action) {
        Node next = first.next;
        for (int i = 1; i <= N; i++) {
            T item = i == 1 ? first.item : next.item ;
            action.accept(item);

            if (i == 1) continue;
            next = next.next;
        }
    }




}
