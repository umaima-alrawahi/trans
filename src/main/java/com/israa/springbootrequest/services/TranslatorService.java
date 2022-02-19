package com.israa.springbootrequest.services;

import com.israa.springbootrequest.entities.TranslatorEntity;
import com.israa.springbootrequest.repositories.TranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.Optional;

@Service
public class TranslatorService {
    private final TranslatorRepository translatorRepository;
    private final String apiUrl = "https://libretranslate.de/translate";

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    public TranslatorService(TranslatorRepository translatorRepository) {
        this.translatorRepository = translatorRepository;
    }

    public String translateFromEnToEs(String text) {
        try {
            TranslatorEntity translatedEntity = TranslatorEntity.builder()
                    .q(text)
                    .source("en")
                    .target("es")
                    .build();
            return fetchTranslation(translatedEntity);
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String translateFromEsToEn(String text) {
        try {
            TranslatorEntity translatedEntity = TranslatorEntity.builder()
                    .q(text)
                    .source("es")
                    .target("en")
                    .build();
            return fetchTranslation(translatedEntity);
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    private String fetchTranslation(TranslatorEntity translatedEntity) {
        RestTemplate restTemplate = getRestTemplate();
        ResponseEntity<TranslatorEntity> response = restTemplate.postForEntity(apiUrl, translatedEntity,
                TranslatorEntity.class);
        return response.getBody().toString();
    }
}
