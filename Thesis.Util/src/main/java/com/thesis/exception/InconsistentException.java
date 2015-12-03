package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractException;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public class InconsistentException extends AbstractException {

    public InconsistentException() {    }

    public InconsistentException(String message) {
        super(message);
    }
}
