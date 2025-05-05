package com.jvictornascimento.urlshortene.dtos;

public record ResponseGetShortUrlByUser(
        String short_url,
        String original_url,
        int clicks
) {
}
