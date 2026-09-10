package com.laurapuerto.sentiment.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurapuerto.sentiment.domain.Sentiment;
import com.laurapuerto.sentiment.domain.SentimentAnalyzer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sentiment")
public class SentimentController {

    private final SentimentAnalyzer sentimentAnalyzer;

    public SentimentController(SentimentAnalyzer sentimentAnalyzer) {
        this.sentimentAnalyzer = sentimentAnalyzer;
    }

    @PostMapping
    public SentimentResponse analyze(@Valid @RequestBody SentimentRequest request) {
        Sentiment sentiment = sentimentAnalyzer.analyze(request.text());

        return new SentimentResponse(sentiment);
    }
}
