package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractRuntimeException;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public class InconsistentException extends AbstractRuntimeException {

    public InconsistentException() {    }

    public InconsistentException(String message) {
        super(message);
    }
}
