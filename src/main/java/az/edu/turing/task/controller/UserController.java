package az.edu.turing.task.controller;

import az.edu.turing.task.domain.entity.User;
import az.edu.turing.task.model.UserDto;
import az.edu.turing.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/creat-profile")
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getStudentById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
