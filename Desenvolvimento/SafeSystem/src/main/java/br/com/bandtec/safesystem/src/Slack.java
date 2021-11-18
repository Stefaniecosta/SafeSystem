/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Bruno
 */
public class Slack {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }

    public static void enviarRelatorio(Integer fkAgencia) throws IOException, InterruptedException {

        // Necessita da fkAgencia para fazer o select no banco
        // O objeto Relatorio retorna uma string com o relarorio montado
        Relatorio relatorio = new Relatorio(fkAgencia);

        //Tranforma o relatorio em JSON para a API
        JSONObject json = new JSONObject();
        json.put("text", relatorio.novoRegistro());

        Slack.sendMessage(json);
    }

}
