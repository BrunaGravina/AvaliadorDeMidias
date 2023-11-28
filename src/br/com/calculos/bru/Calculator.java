package br.com.calculos.bru;

import br.com.modelos.bru.Title;

public class Calculator {

    private int tempoTotal;

    public void inclui(Title titulo) {
        tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

}
