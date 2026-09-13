package com.laurapuerto.sentiment.infrastructure.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.laurapuerto.sentiment.domain.Sentiment;
import com.laurapuerto.sentiment.domain.SentimentAnalyzer;

@Service
@ConditionalOnProperty(name = "sentiment.analyzer", havingValue = "llm")
public class LlmSentimentAnalyzer implements SentimentAnalyzer {

    private final ChatClient chatClient;

    public LlmSentimentAnalyzer(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public Sentiment analyze(String text) {
        SentimentResult result = chatClient.prompt()
                .user("""
                        Classify the sentiment of this customer feedback.

                        Feedback:
                        %s
                        """.formatted(text))
                .call()
                .entity(
                        SentimentResult.class,
                        spec -> spec.useProviderStructuredOutput());

        return result.sentiment();
    }
}
