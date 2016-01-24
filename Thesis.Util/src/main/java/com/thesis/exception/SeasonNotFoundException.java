package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractException;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public class SeasonNotFoundException extends AbstractException {

    public SeasonNotFoundException() {
    }

    public SeasonNotFoundException(String message) {
        super(message);
    }
}
