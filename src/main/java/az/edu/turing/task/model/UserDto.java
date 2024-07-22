package az.edu.turing.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String username;
    private int age;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String profilePhoto;
}
