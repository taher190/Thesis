package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractRuntimeException;

public class SeasonException extends AbstractRuntimeException {

    public SeasonException() {
    }

    public SeasonException(String message) {
        super(message);
    }
}
