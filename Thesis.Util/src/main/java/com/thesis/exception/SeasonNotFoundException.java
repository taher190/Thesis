package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractRuntimeException;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public class SeasonNotFoundException extends AbstractRuntimeException {

    public SeasonNotFoundException() {
    }

    public SeasonNotFoundException(String message) {
        super(message);
    }
}
