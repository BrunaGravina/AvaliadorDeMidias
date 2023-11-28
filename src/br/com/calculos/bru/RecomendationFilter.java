package br.com.calculos.bru;

import br.com.modelos.bru.Title;

public class RecomendationFilter {
    private String recomendacao;

    public void filtra(Score classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}