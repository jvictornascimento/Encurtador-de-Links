package com.jvictornascimento.urlshortene.dtos;

public record ResponseGetShortUrlByUserDTO(
        String short_url,
        String original_url,
        int clicks
) {
}
