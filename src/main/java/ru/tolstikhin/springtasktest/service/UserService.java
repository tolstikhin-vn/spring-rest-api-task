package ru.tolstikhin.springtasktest.service;

import org.springframework.http.ResponseEntity;
import ru.tolstikhin.springtasktest.model.User;

public interface UserService {
    ResponseEntity<Object> save(User user);

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateUser(Long id);
}
