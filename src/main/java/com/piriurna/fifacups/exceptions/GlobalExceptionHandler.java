package com.piriurna.fifacups.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.piriurna.fifacups.domain.dto.response.MessageResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<MessageResponse> unauthorizedExceptionHandler(UnauthorizedException ex) {
        return new ResponseEntity<MessageResponse>(new MessageResponse(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<MessageResponse> unexpectedExceptionHandler(UnexpectedException ex) {
        return new ResponseEntity<MessageResponse>(new MessageResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<MessageResponse> duplicateEntryException(DuplicateEntryException ex) {
        return new ResponseEntity<MessageResponse>(new MessageResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }
}
