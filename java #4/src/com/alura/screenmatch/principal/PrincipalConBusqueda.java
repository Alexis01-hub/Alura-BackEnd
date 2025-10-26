package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el nombre de una película o serie para buscar en OMDB:");
        String busqueda = lectura.nextLine();

        String direccion = "http://www.omdbapi.com/?t="+busqueda+"&apikey=449f5547";

        HttpClient client = HttpClient.newHttpClient(); //Crea el cliente HTTP
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build(); //Crea la solicitud HTTP
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Envía la solicitud y obtiene la respuesta

        String json = response.body();
        System.out.println(json); //Imprime el cuerpo de la respuesta en JSON

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(miTituloOmdb);

        Titulo miTitulo = new Titulo(miTituloOmdb);
        System.out.println(miTitulo);
    }
}
