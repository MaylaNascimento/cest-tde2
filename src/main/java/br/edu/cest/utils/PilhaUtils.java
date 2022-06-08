package br.edu.cest.utils;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class PilhaUtils<T extends Number> {
    private Stack<T> dados;

    public PilhaUtils(Stack<T> dados) {
        this.dados = dados;
    }

    public Stack<T> getDados() {
        return dados;
    }

    public void setDados(Stack<T> dados) {
        this.dados = dados;
    }

    public T menor() {
       return dados.stream().sorted().collect(Collectors.toList()).get(0);
    }

    public T maior() {
        List<T> collect = dados.stream().sorted().collect(Collectors.toList());
        return collect.get(collect.size() - 1);
    }

    public int media() {
        int size = dados.size();
        int sum = dados.stream().mapToInt((Number::intValue)).sum();
        return sum / size;
    }

}
