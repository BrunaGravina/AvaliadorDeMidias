package br.com.principal.bru;

import br.com.modelos.bru.Movie;
import br.com.modelos.bru.Show;
import br.com.modelos.bru.Title;

import java.util.ArrayList;

public class PrincipalWithLists {
    public static void main(String[] args) {
        Movie favorito = new Movie("Star Wars Episódio IV - Uma nova esperança", 1970);

        Movie outro = new Movie("Detona Ralph", 2013);

        Movie terceiroFilme = new Movie("Jogos Vorazes", 2012);

        Show serie = new Show("La Casa de Papel", 2017);

        ArrayList<Title> Watched = new ArrayList<>();
        Watched.add(terceiroFilme);
        Watched.add(outro);
        Watched.add(favorito);
        Watched.add(serie);
        System.out.println("O tamanho da sua lista de filmes é: " + Watched.size());
        System.out.println("Primeiro filme: " + Watched.get(0).getNome());
        System.out.println("Minha lista: " + Watched);
    }
}
