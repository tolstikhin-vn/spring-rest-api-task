package ru.tolstikhin.springtasktest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tolstikhin.springtasktest.model.User;
import ru.tolstikhin.springtasktest.service.UserService;

/**
 * Основной контролллер REST API сервиса
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class Controller {

    UserService userService;

    /**
     * Метод для добавления поиска пользователя в БД
     *
     * @param userId идентификатор пользоветеля
     * @return обертка HTTP-ответа
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * Метод для добавления нового пользователя в БД
     *
     * @param user объект пользователь
     * @return обертка HTTP-ответа
     */
    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Метод для обновления пользовательского статуса в БД
     *
     * @param userId идентификатор пользоветеля
     * @return обертка HTTP-ответа
     */
    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable Long userId) {
        return userService.updateUser(userId);
    }
}
