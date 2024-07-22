package az.edu.turing.task.service;

import az.edu.turing.task.domain.entity.User;
import az.edu.turing.task.domain.repository.UserPostgresRepository;
import az.edu.turing.task.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserPostgresRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.cancelById(id);
    }
}
