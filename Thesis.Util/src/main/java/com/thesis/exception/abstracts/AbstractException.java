package com.thesis.exception.abstracts;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractException extends RuntimeException {

    public AbstractException() {    }

    public AbstractException(String message) {
        super(message);
    }
}
