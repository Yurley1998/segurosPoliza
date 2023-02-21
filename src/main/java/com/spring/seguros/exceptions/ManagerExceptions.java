package com.spring.seguros.exceptions;

public class ManagerExceptions extends Exception{

        public ManagerExceptions() {
        }

        public ManagerExceptions(String message) {
            super(message);
        }

        public ManagerExceptions(String message, Throwable cause) {
            super(message, cause);
        }

        public ManagerExceptions(Throwable cause) {
            super(cause);
        }

        public ManagerExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

