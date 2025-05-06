package com.jvictornascimento.urlshortene.controllers;

import com.jvictornascimento.urlshortene.config.security.TokenService;
import com.jvictornascimento.urlshortene.dtos.AuthenticationDTO;
import com.jvictornascimento.urlshortene.dtos.ResponseLoginDTO;
import com.jvictornascimento.urlshortene.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generationToken((UserModel) auth.getPrincipal());
        return ResponseEntity.ok(new ResponseLoginDTO(token));
    }
}
