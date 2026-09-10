package com.laurapuerto.sentiment.domain;

public interface SentimentAnalyzer {

    Sentiment analyze(String text);
}
