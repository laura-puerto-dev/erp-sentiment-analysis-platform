package com.laurapuerto.sentiment.api;

import jakarta.validation.constraints.NotBlank;

public record SentimentRequest(
        @NotBlank String text) {
}
