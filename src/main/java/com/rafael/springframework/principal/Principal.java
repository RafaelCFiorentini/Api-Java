package com.rafael.springframework.principal;
import com.rafael.springframework.model.DadosEpisodio;
import com.rafael.springframework.model.DadosSerie;
import com.rafael.springframework.model.DadosTemporada;
import com.rafael.springframework.model.Episodio;
import com.rafael.springframework.service.ConsumirApi;
import com.rafael.springframework.service.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumirApi consumo = new ConsumirApi();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY;

    public Principal(String omdbApiKey) {
        this.API_KEY = "&apikey=" + omdbApiKey;
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da série para a busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        ConverterDados conversor = new ConverterDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        	List<DadosTemporada> temporadas = new ArrayList<>();
	for (int i = 1; i <= dados.totaltemporadas(); i++){
     json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season="+i + API_KEY);
		DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
		temporadas.add(dadosTemporada);
	}
	temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\n Top 5 episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);


        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);
    }
}
