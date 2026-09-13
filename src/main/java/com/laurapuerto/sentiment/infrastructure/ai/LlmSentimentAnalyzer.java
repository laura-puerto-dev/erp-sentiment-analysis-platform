package com.laurapuerto.sentiment.infrastructure.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.laurapuerto.sentiment.domain.Sentiment;
import com.laurapuerto.sentiment.domain.SentimentAnalyzer;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Service
@ConditionalOnProperty(name = "sentiment.analyzer", havingValue = "llm")
public class LlmSentimentAnalyzer implements SentimentAnalyzer {

    private final ChatClient chatClient;

    public LlmSentimentAnalyzer(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    @SuppressFBWarnings(value = "VA_FORMAT_STRING_USES_NEWLINE", justification = "Newlines are intentional formatting in the LLM prompt")
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

        if (result == null) {
            throw new IllegalStateException("LLM returned an empty sentiment response");
        }

        return result.sentiment();
    }
}
