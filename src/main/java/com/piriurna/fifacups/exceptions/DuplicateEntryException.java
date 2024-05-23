package com.piriurna.fifacups.exceptions;

public class DuplicateEntryException extends RuntimeException {
    public DuplicateEntryException() {
        super("Duplicate entry");
    }
}
