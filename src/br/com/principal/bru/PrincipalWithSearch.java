package br.com.principal.bru;

import br.com.modelos.bru.Title;
import br.com.modelos.bru.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalWithSearch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner e = new Scanner(System.in);
        try {
            System.out.println("Digite um filme para a busca");
            String search = e.nextLine();

            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=855322df";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);

            Title myTitle = new Title(titleOmdb);
            System.out.println(titleOmdb);
        } catch (IllegalArgumentException ex) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço");
        } catch (TitleOmdb.YearConversionErrorException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("O programa finalizou corretamente.");
    }
}
