package ru.tolstikhin.springtasktest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tolstikhin.springtasktest.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
