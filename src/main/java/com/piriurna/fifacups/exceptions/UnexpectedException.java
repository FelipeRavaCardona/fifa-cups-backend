package com.piriurna.fifacups.exceptions;

public class UnexpectedException extends RuntimeException {
    public UnexpectedException() {
        super("An unexpected error occured, please, try again later.");
    }
}
