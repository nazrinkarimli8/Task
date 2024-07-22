package az.edu.turing.task.database;

public class SqlQueries {
    public static final String createUser = "INSERT INTO userss (username, age, created, updated,profile_photo) VALUES (?, ?, ?, ?,?);";
    public static final String getAllUserQuery = "SELECT * FROM userss;";
    public static final String findUserByIdQuery = "SELECT * FROM userss WHERE id=?;";
    public static final String deleteUserQuery = "DELETE FROM userss WHERE id = ?;";
}
