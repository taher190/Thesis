package com.thesis.exception;

import com.thesis.exception.abstracts.AbstractRuntimeException;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public class ManyThesisAppealAttemptException extends AbstractRuntimeException {

    public ManyThesisAppealAttemptException() {    }

    public ManyThesisAppealAttemptException(String message) {
        super(message);
    }
}
