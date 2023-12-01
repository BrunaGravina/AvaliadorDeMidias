package br.com.modelos.bru;

import br.com.calculos.bru.Score;

public class Movie extends Title implements Score {

    private String diretor;

    public Movie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }

}



