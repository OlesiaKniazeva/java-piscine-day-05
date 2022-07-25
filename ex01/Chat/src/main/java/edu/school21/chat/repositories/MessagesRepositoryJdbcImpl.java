package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    public Optional<Message> findById(Long id) {
        String text = null;
        Timestamp time = null;
        Long author_id = null;
        Long room_id = null;

        try {
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE id=" + id);
            if (!resultSet.next()) {
                return Optional.of(new Message(0L, null, null, "no message", null));
            }
            text = resultSet.getString("message");
            time = resultSet.getTimestamp("date");
            author_id = resultSet.getLong("author_id");
            room_id = resultSet.getLong("room_id");

            resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + author_id);
            resultSet.next();

            User user = new User(author_id, resultSet.getString("login"), resultSet.getString("password"), null, null);

            resultSet = statement.executeQuery("SELECT * FROM rooms WHERE id=" + room_id);
            resultSet.next();

            Chatroom chatroom = new Chatroom(room_id, resultSet.getString("name"), null, null);

            return Optional.of(new Message(resultSet.getLong("id"), user, chatroom, text, time.toLocalDateTime()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
