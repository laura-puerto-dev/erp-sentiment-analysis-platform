package com.laurapuerto.sentiment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SentimentAnalyzerTest {

    @Test
    void returnsNeutralSentiment() {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        Sentiment result = analyzer.analyze("Any customer feedback");

        assertEquals(Sentiment.NEUTRAL, result);
    }

    @Test
    void returnsPositiveSentimentForPositiveText() {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        Sentiment result = analyzer.analyze("The product is excellent");

        assertEquals(Sentiment.POSITIVE, result);
    }

    @Test
    void returnsNegativeSentimentForNegativeText() {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        Sentiment result = analyzer.analyze("The product is terrible");

        assertEquals(Sentiment.NEGATIVE, result);
    }
}
