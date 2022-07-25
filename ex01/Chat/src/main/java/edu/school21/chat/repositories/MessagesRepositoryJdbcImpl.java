package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final Connection connection;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Message> findById(Long id) {
        String text;
        Timestamp time;
        long author_id;
        long room_id;
        User user;
        Chatroom chatroom;

            try (Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE id=" + id)) {
                    if (!resultSet.next()) {
                        return Optional.empty();
                    }
                    text = resultSet.getString("message");
                    time = resultSet.getTimestamp("date");
                    author_id = resultSet.getLong("author_id");
                    room_id = resultSet.getLong("room_id");
                }

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + author_id)) {
                    resultSet.next();

                    user = new User(author_id, resultSet.getString("login"), resultSet.getString("password"), null, null);
                }
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM rooms WHERE id=" + room_id)){
                    resultSet.next();

                    chatroom = new Chatroom(room_id, resultSet.getString("name"), null, null);
                    return Optional.of(new Message(resultSet.getLong("id"), user, chatroom, text, time.toLocalDateTime()));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}
