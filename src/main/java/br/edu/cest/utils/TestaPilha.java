package br.edu.cest.utils;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TestaPilha {

    private Stack<Number> dados;

    public Stack<Number> getDados() {
        return dados;
    }

    public void setDados(Stack<Number> dados) {
        this.dados = dados;
    }

    public void inserirPairOrRemove(Number item) {
        boolean isPair = item.intValue() % 2 == 0;
        if (isPair) {
            dados = dados == null ? new Stack<>() : dados;
            dados.push(item);
        }
        if (!isPair && !dados.empty()) {
            dados.pop();
        }
    }
}
