package com.laurapuerto.sentiment.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HeuristicSentimentAnalyzerTest {

    @Test
    void returnsNeutralSentiment() {
        HeuristicSentimentAnalyzer analyzer = new HeuristicSentimentAnalyzer();

        Sentiment result = analyzer.analyze("Any customer feedback");

        assertEquals(Sentiment.NEUTRAL, result);
    }

    @Test
    void returnsPositiveSentimentForPositiveText() {
        HeuristicSentimentAnalyzer analyzer = new HeuristicSentimentAnalyzer();

        Sentiment result = analyzer.analyze("The product is excellent");

        assertEquals(Sentiment.POSITIVE, result);
    }

    @Test
    void returnsNegativeSentimentForNegativeText() {
        HeuristicSentimentAnalyzer analyzer = new HeuristicSentimentAnalyzer();

        Sentiment result = analyzer.analyze("The product is terrible");

        assertEquals(Sentiment.NEGATIVE, result);
    }

    @Test
    void doesNotMatchSentimentWordsInsideOtherWords() {
        HeuristicSentimentAnalyzer analyzer = new HeuristicSentimentAnalyzer();

        Sentiment result = analyzer.analyze("The badge is blue");

        assertEquals(Sentiment.NEUTRAL, result);
    }
}
