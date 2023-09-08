package ru.tolstikhin.springtasktest.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.tolstikhin.springtasktest.DTO.UserDTO;
import ru.tolstikhin.springtasktest.enums.Status;
import ru.tolstikhin.springtasktest.exception.UserExistingEmailException;
import ru.tolstikhin.springtasktest.exception.UserNotFoundException;
import ru.tolstikhin.springtasktest.model.User;
import ru.tolstikhin.springtasktest.repo.UserRepo;
import ru.tolstikhin.springtasktest.response.ResponseHandler;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    /**
     * Логика сохранения пользователя в БД
     * @param user объект пользователь
     * @return ответ на запрос
     */
    @Override
    public ResponseEntity<Object> save(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistingEmailException("Email already exist");
        }

        long id = userRepo.save(user).getId();
        return ResponseHandler.responseBuilder("User was saved", HttpStatus.OK, id);
    }

    /**
     * Логика поиска пользователя по id
     * @param id идентификатор пользователя
     * @return ответ на запрос
     */
    @Override
    public ResponseEntity<Object> findById(Long id) {
        if (!userRepo.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exist");
        }
        return ResponseHandler.responseBuilder("User was saved", HttpStatus.OK, userRepo.findById(id).get());
    }

    /**
     * Логика обновления пользовательских данных
     * @param id идентификатор пользователя
     * @return ответ на запрос
     */
    @Override
    public ResponseEntity<Object> updateUser(Long id) {
        if (userRepo.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exist");
        }
        User user = userRepo.findById(id).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPrevStatus(user.getStatus());

        // Меняем статус на онлайн, если был офлайн
        String offlineStatusString = Status.OFFLINE.getStatusString();
        if (user.getStatus().equals(offlineStatusString)) {
            String onlineStatusString = Status.ONLINE.getStatusString();
            userDTO.setCurStatus(onlineStatusString);
        }
        return ResponseHandler.responseBuilder("User was updated", HttpStatus.OK, userDTO);
    }
}
