import br.com.calculos.bru.Calculator;
import br.com.calculos.bru.RecomendationFilter;
import br.com.modelos.bru.Episodes;
import br.com.modelos.bru.Movie;
import br.com.modelos.bru.Show;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Movie favorito = new Movie("Star Wars Episódio IV - Uma nova esperança", 1970);
        favorito.setDuracaoEmMinutos(180);
        favorito.setIncluidoNoPlano(true);

        Movie outro = new Movie("Detona Ralph", 2013);
        outro.setDuracaoEmMinutos(100);
        outro.setIncluidoNoPlano(true);

        Movie terceiroFilme = new Movie("Jogos Vorazes", 2012);
        terceiroFilme.setDuracaoEmMinutos(142);
        terceiroFilme.setIncluidoNoPlano(true);
        terceiroFilme.setDiretor("Francis Lawrence");
        terceiroFilme.avalia(5);

        Show serie = new Show("La Casa de Papel", 2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(45);

        Calculator calculadora = new Calculator();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);
        calculadora.inclui(terceiroFilme);

        System.out.println("Tempo total: " +calculadora.getTempoTotal());

        Episodes episodio = new Episodes();
        episodio.setNome("Piloto");
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(900);

        RecomendationFilter filtro = new RecomendationFilter();
        filtro.filtra(favorito);
        filtro.filtra(episodio);
        filtro.filtra(serie);
        filtro.filtra(outro);
        filtro.filtra(terceiroFilme);

        ArrayList<Movie>MovieList = new ArrayList<>();
        MovieList.add(terceiroFilme);
        MovieList.add(outro);
        MovieList.add(favorito);
        System.out.println("O tamanho da sua lista de filmes é: " + MovieList.size());
        System.out.println("Primeiro filme: " + MovieList.get(0).getNome());
        System.out.println("Minha lista: " + MovieList);



    }
}
