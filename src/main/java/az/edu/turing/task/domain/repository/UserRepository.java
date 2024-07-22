package az.edu.turing.task.domain.repository;

import az.edu.turing.task.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    List<User> findAll();

    User findById(Long id);

    void cancelById(Long id);
}
