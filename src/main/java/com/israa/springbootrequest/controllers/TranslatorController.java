package com.israa.springbootrequest.controllers;

import com.israa.springbootrequest.services.TranslatorService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
public class TranslatorController {
    private final TranslatorService translatorService;

    @Autowired
    public TranslatorController(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @PostMapping("/translateFromEnToEs")
    public String translateFromEnToEs(@RequestBody @NotNull String text) {
        return this.translatorService.translateFromEnToEs(text);
    }

    @PostMapping("/translateFromEsToEn")
    public String translateFromEsToEn(@RequestBody @NotNull String text) {
        return this.translatorService.translateFromEsToEn(text);
    }
}
