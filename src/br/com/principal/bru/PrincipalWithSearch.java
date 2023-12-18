package br.com.principal.bru;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalWithSearch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner e = new Scanner(System.in);
        System.out.println("Digite um filme para a busca");
        String search = e.nextLine();

        String address = "https://www.omdbapi.com/?t=" + search + "&apikey=855322df";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
