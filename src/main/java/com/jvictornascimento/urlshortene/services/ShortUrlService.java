package com.jvictornascimento.urlshortene.services;

import com.jvictornascimento.urlshortene.dtos.ResponseDeleteShortUrlDTO;
import com.jvictornascimento.urlshortene.dtos.ResponseGetShortUrlByUser;
import com.jvictornascimento.urlshortene.dtos.ResponseShortUrlDTO;
import com.jvictornascimento.urlshortene.dtos.ShortUrlDTO;
import com.jvictornascimento.urlshortene.models.ShortUrl;
import com.jvictornascimento.urlshortene.models.UserModel;
import com.jvictornascimento.urlshortene.repositories.ShortUrlRepository;
import com.jvictornascimento.urlshortene.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.jvictornascimento.urlshortene.services.utils.ShortHashUtil.GeneratorShortHash;

@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository repository;
    @Autowired
    private UserRepository userRepository;

    public ResponseShortUrlDTO Shoten(ShortUrlDTO originUrlDTO){
        var shortUrl = new ShortUrl(
                null,
                GeneratorShortHash(originUrlDTO.url()),
                originUrlDTO.url(),
                0,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                VerifyUser(originUrlDTO.userId()
        ));
        repository.save(shortUrl);
        return new ResponseShortUrlDTO(shortUrl.getHash(),shortUrl.getOriginalUrl());

    }

    public List<ResponseGetShortUrlByUser> getListByUser(Long userId){
        var user = VerifyUser(userId);
        return user.getListURL().stream().map(
                u -> new ResponseGetShortUrlByUser(
                        u.getHash(),
                        u.getOriginalUrl(),
                        u.getClickCount())
        ).toList();
    }


    private UserModel VerifyUser(Long userId) {
       return userRepository.findById(userId)
               .orElseThrow(() -> new RuntimeException("User not exists"));
    }


    public ResponseDeleteShortUrlDTO deleteShortUrl(String shortCode) {
        String message ;
        try {
            if (repository.deleteByHash(shortCode) > 0) {
                message = "Link deleted successfully.";
            }else{
                message = "Link not found!"; //depois criar excessao propria
            }
            return new ResponseDeleteShortUrlDTO(message);
        }catch (Exception e){
            throw new RuntimeException("Failed to delete short URL: " + e.getMessage());
        }
    }
}
