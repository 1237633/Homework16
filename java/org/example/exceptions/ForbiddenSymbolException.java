package org.example.exceptions;

public class ForbiddenSymbolException extends Exception{
    public ForbiddenSymbolException() {
    }

    public ForbiddenSymbolException(String message) {
        super(message);
    }

    public ForbiddenSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenSymbolException(Throwable cause) {
        super(cause);
    }
}
