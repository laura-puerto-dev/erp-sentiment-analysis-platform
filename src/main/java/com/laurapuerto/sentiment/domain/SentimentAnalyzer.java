package com.laurapuerto.sentiment.domain;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class SentimentAnalyzer {

    private static final Set<String> POSITIVE_WORDS = Set.of(
            "excellent",
            "great",
            "good",
            "amazing",
            "love");

    private static final Set<String> NEGATIVE_WORDS = Set.of(
            "terrible",
            "bad",
            "awful",
            "horrible",
            "hate");

    public Sentiment analyze(String text) {
        String normalizedText = text.toLowerCase();

        if (containsAny(normalizedText, POSITIVE_WORDS)) {
            return Sentiment.POSITIVE;
        }

        if (containsAny(normalizedText, NEGATIVE_WORDS)) {
            return Sentiment.NEGATIVE;
        }

        return Sentiment.NEUTRAL;
    }

    private boolean containsAny(String text, Set<String> words) {
        String[] tokens = text.split("\\W+");

        for (String token : tokens) {
            if (words.contains(token)) {
                return true;
            }
        }

        return false;
    }
}
