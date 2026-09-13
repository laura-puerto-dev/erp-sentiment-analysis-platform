package com.laurapuerto.sentiment.infrastructure.ai;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laurapuerto.sentiment.domain.Sentiment;

@SpringBootTest
class LlmSentimentAnalyzerIT {

    @Autowired
    private LlmSentimentAnalyzer sentimentAnalyzer;

    @Test
    void classifiesPositiveSentimentUsingOllama() {
        Sentiment result = sentimentAnalyzer.analyze("The product is excellent.");

        assertThat(result).isEqualTo(Sentiment.POSITIVE);
    }
}
