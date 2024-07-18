package br.com.investTracker;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
    private final Object parameter;
}
