package com.spring.seguros.exceptions;

public class FacadeExceptions extends Exception {

        public FacadeExceptions() {
        }

        public FacadeExceptions(String message) {
            super(message);
        }

        public FacadeExceptions(String message, Throwable cause) {
            super(message, cause);
        }

        public FacadeExceptions(Throwable cause) {
            super(cause);
        }

        public FacadeExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

