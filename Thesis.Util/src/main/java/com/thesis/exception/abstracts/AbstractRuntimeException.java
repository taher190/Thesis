package com.thesis.exception.abstracts;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractRuntimeException extends RuntimeException {

    public AbstractRuntimeException() {    }

    public AbstractRuntimeException(String message) {
        super(message);
    }
}
