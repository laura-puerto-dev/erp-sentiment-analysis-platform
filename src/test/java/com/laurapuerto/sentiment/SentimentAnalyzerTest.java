package com.laurapuerto.sentiment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SentimentAnalyzerTest {

    @Test
    void returnsNeutralSentiment() {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        Sentiment result = analyzer.analyze("Any customer feedback");

        assertEquals(Sentiment.NEUTRAL, result);
    }
}
