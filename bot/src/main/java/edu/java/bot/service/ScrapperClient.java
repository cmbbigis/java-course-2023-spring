package edu.java.bot.service;

import edu.java.bot.api.request.LinkUpdate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class ScrapperClient {

    private final WebClient webClient;

    public ScrapperClient(String baseUrl) {
        this.webClient = WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

    public Mono<LinkUpdate> postUpdate(LinkUpdate update) {
        return webClient.post()
            .uri("/updates")
            .bodyValue(update)
            .retrieve()
            .bodyToMono(LinkUpdate.class);
    }
}
