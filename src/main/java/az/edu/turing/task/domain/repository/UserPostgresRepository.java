package az.edu.turing.task.domain.repository;

import az.edu.turing.task.database.JdbcConnection;
import az.edu.turing.task.database.SqlQueries;
import az.edu.turing.task.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Timestamp.valueOf;

@Repository
public class UserPostgresRepository implements UserRepository {

    @Override
    public void save(User user) {
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.createUser)) {
            stmt.setString(1, user.getUsername());
            stmt.setInt(2, user.getAge());
            stmt.setTimestamp(3, valueOf(user.getCreated()));
            stmt.setTimestamp(4, valueOf(user.getUpdated()));
            stmt.setString(5, user.getProfilePhoto());
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("Inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.getAllUserQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getInt("age"),
                        resultSet.getTimestamp("created").toLocalDateTime(),
                        resultSet.getTimestamp("updated").toLocalDateTime(),
                        resultSet.getString("profile_photo")
                );
                usersList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    @Override
    public User findById(Long id) {
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.findUserByIdQuery)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getInt("age"),
                        resultSet.getTimestamp("created").toLocalDateTime(),
                        resultSet.getTimestamp("updated").toLocalDateTime(),
                        resultSet.getString("profile_photo")
                );
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cancelById(Long id) {
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.deleteUserQuery)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}