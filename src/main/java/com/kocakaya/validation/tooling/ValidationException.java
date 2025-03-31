package com.kocakaya.validation.tooling;

import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private List<String> messages;

    public ValidationException(List<String> messages) {
        super();
        this.messages = messages;
    }
}
