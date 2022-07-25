package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    private final User author;
    private final Chatroom chatroom;
    private final String text;
    private final LocalDateTime date;

    public Message(Long id, User author, Chatroom chatroom, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && Objects.equals(author, message.author) && Objects.equals(chatroom, message.chatroom) && Objects.equals(text, message.text) && Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, chatroom, text, date);
    }

    @Override
    public String toString() {
        String formatDateTime = null;
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            formatDateTime = date.format(formatter);
        }
        return "Message: {\n" +
                " id=" + id +
                ",\n author=" + author +
                ",\n chatroom=" + chatroom +
                ",\n text='" + text + '\'' +
                ",\n date=" + formatDateTime +
                '}';
    }
}
