package ru.tolstikhin.springtasktest.exception;

public class UserExistingEmailException extends RuntimeException {
    public UserExistingEmailException(String message) {
        super(message);
    }
}
