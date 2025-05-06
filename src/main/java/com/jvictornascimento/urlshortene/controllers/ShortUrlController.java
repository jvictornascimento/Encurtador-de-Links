package com.jvictornascimento.urlshortene.controllers;

import com.jvictornascimento.urlshortene.dtos.ResponseDeleteShortUrlDTO;
import com.jvictornascimento.urlshortene.dtos.ResponseGetShortUrlByUser;
import com.jvictornascimento.urlshortene.dtos.ResponseShortUrlDTO;
import com.jvictornascimento.urlshortene.dtos.ShortUrlDTO;
import com.jvictornascimento.urlshortene.services.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class ShortUrlController {
    @Autowired
    private ShortUrlService service;

    @PostMapping(value = "/shorten")
    public ResponseEntity<ResponseShortUrlDTO> shortenUrl(@RequestBody ShortUrlDTO originUrl){
        return ResponseEntity.ok().body(service.Shoten(originUrl));
    }
    @GetMapping(value = "/links/{userId}")
    public ResponseEntity<List<ResponseGetShortUrlByUser>> getListByUser(@PathVariable Long userId){
        return ResponseEntity.ok().body(service.getListByUser(userId));
    }

    @DeleteMapping(value = "/links/{short_code}")
    public ResponseEntity<ResponseDeleteShortUrlDTO> deleteShortUrl(@PathVariable String short_code){
        return ResponseEntity.ok().body(service.deleteShortUrl(short_code));
    }

}
