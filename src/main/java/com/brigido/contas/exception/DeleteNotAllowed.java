package com.brigido.contas.exception;

public class DeleteNotAllowed extends RuntimeException {

    public DeleteNotAllowed(String message) {
        super(message);
    }
}
