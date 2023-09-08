package ru.tolstikhin.springtasktest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    /**
     * Метод для формирования ответа с исключением "пользователь не найден"
     *
     * @param userNotFoundException исключение "пользователь не найден"
     * @return обертка HTTP-ответа
     */
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        UserException userException = new UserException(
                userNotFoundException.getMessage(),
                userNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }

    /**
     * Метод для формирования ответа с исключением "email уже существует"
     *
     * @param UserExistingEmailException исключение "email уже существует"
     * @return обертка HTTP-ответа
     */
    @ExceptionHandler(value = {UserExistingEmailException.class})
    public ResponseEntity<Object> handleUserExistingEmailException(UserExistingEmailException UserExistingEmailException) {
        UserException userException = new UserException(
                UserExistingEmailException.getMessage(),
                UserExistingEmailException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }
}
