package br.com.principal.bru;

import br.com.modelos.bru.Movie;
import br.com.modelos.bru.Show;
import br.com.modelos.bru.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalWithLists {
    public static void main(String[] args) {
        Movie favorito = new Movie("Star Wars Episódio IV - Uma nova esperança", 1970);

        Movie outro = new Movie("Detona Ralph", 2013);

        Movie terceiroFilme = new Movie("Jogos Vorazes", 2012);

        Show serie = new Show("La Casa de Papel", 2017);

        List<Title> Watched = new ArrayList<>();
        Watched.add(terceiroFilme);
        Watched.add(outro);
        Watched.add(favorito);
        Watched.add(serie);

        Collections.sort(Watched);
        System.out.println("Lista de títulos ordenados por ordem alfabética: " + Watched);

        Watched.sort(Comparator.comparing(Title::getAnoDeLancamento));
        System.out.println("Por ano de lançamento: " + Watched);

//        System.out.println("O tamanho da sua lista de filmes é: " + Watched.size());
//        System.out.println("Primeiro filme: " + Watched.get(0).getNome());
//        System.out.println("Minha lista: " + Watched);
//        Exemplos de métodos de Array List.


        for (Title item : Watched) {
            System.out.println(item);
            if (item instanceof Movie filme && filme.getClassificacao() > 2) {
                System.out.println("Classificacao: " + filme.getClassificacao());
            }

        }

        List<String> findByArtist = new ArrayList<>();
        findByArtist.add("Jennifer Lawrence");
        findByArtist.add("Mark Hamill");
        findByArtist.add("Brie Larson");

        Collections.sort(findByArtist); //Ordem alfabética
        System.out.println(findByArtist);

    }
}
