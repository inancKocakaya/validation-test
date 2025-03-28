package com.kocakaya.validation.exception;

import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private List<String> messages;

    public ValidationException(List<String> messages) {
        this.messages = messages;
    }
}
