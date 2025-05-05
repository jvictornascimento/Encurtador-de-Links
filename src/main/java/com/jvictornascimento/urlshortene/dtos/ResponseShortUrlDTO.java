package com.jvictornascimento.urlshortene.dtos;

public record ResponseShortUrlDTO(
        String short_url,
        String original_url
) {
}
