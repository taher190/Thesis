package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractRuntimeException;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public class StudentActivityNotFoundException extends AbstractRuntimeException {

    public StudentActivityNotFoundException() {
    }

    public StudentActivityNotFoundException(String message) {
        super(message);
    }
}
