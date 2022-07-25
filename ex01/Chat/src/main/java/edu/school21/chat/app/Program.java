package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id: ");
        while (!sc.hasNextLong()) {
            System.out.println("Enter user id: ");
            sc.next();
        }
        Long id = sc.nextLong();

        Optional<Message> message = repo.findById(id);

        if (message.isPresent()) {
            Message m = message.get();
            System.out.println(m);
        } else {
            System.out.println("No message found");
        }
    }
}
