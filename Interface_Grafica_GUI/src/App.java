package com.example;

import com.google.common.collect.ImmutableList;
import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import java.util.List;

public class App {
  public static void main(String[] args) {
    try {
      // Pegando a chave da API
    	//AIzaSyAl7BR2bIsWExNhnxbAgCC_IIryFOR7yiQ
      String apiKey = System.getenv("GEMINI_API_KEY");
      if (apiKey == null || apiKey.isEmpty()) {
        throw new RuntimeException("A variável de ambiente GEMINI_API_KEY não está definida.");
      }

      // Criando o cliente da API
      Client client = Client.builder().apiKey(apiKey).build();

      // Entrada do usuário
      List<Content> contents = ImmutableList.of(
          Content.builder()
              .role("user")
              .parts(ImmutableList.of(
                  Part.fromText("Qual é a capital da França?")
              ))
              .build()
      );

      // Configurações da requisição
      GenerateContentConfig config = GenerateContentConfig.builder()
          .responseMimeType("text/plain")
          .build();

      // Fazendo a requisição para o modelo Gemini
      String model = "gemini-2.5-pro-preview-05-06";
      ResponseStream<GenerateContentResponse> responseStream =
          client.models.generateContentStream(model, contents, config);

      // Lendo e imprimindo as respostas
      for (GenerateContentResponse res : responseStream) {
        res.candidates().ifPresent(candidates -> {
          if (!candidates.isEmpty()) {
            candidates.get(0).content().ifPresent(content -> {
              content.parts().ifPresent(parts -> {
                for (Part part : parts) {
                  System.out.println("Resposta: " + part.text());
                }
              });
            });
          }
        });
      }

      responseStream.close();

    } catch (Exception e) {
      System.err.println("Erro ao gerar conteúdo: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
