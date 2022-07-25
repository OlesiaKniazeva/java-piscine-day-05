package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    private static final String USER = "post";
    private static final String PASSWORD = "post";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        MessagesRepository repo = new MessagesRepositoryJdbcImpl(dataSource);

        User creator = new User(10L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(2L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        repo.save(message);
        System.out.println(message.getId());
        try {
            dataSource.getConnection().close();
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
