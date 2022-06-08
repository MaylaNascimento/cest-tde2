package br.edu.cest.utils;

public interface IFila<T> {
    boolean estaVazia();

    void inserir(T item);

    T remover();

    int tamanho();
}
