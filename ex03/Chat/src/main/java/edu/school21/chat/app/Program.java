package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;

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

        Optional<Message> messageOptional = repo.findById(2L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDate(null);
            repo.update(message);
        }
    }
}