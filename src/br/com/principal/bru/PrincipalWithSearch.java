package br.com.principal.bru;

import br.com.modelos.bru.Title;
import br.com.modelos.bru.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalWithSearch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner e = new Scanner(System.in);

        String search = "";

        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para a busca");
            search = e.nextLine();
            if (search.equalsIgnoreCase("sair")) {
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=855322df";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
                Title myTitle = new Title(titleOmdb);
                System.out.println(titleOmdb);

                titles.add(myTitle);
            } catch (NumberFormatException ex) {
                System.out.println("Ocorreu algum erro.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (TitleOmdb.YearConversionErrorException ex) {
                throw new RuntimeException(ex);
            }
        }
        FileWriter saving = new FileWriter("listofmovies.json");
        saving.write(gson.toJson(titles));
        saving.close();
        System.out.println("O programa finalizou corretamente.");
    }
}
