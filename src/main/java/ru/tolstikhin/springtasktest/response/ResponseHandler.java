package ru.tolstikhin.springtasktest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для отлавливания и составления ответов на запросы
 */
public class ResponseHandler {
    /**
     * Метод для формирования ответов на запросы
     *
     * @param message        сообщение результата выполнения запроса
     * @param httpStatus     статус ответа
     * @param responseObject объект ответа
     * @return собственный объект обертку HTTP-ответа
     */
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", responseObject);
        response.put("message", message);
        response.put("httpStatus", httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
