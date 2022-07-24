package edu.school21.chat.models;

import java.util.List;

public class User {
    private final Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> joinedRooms;

    public User(Long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> joinedRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.joinedRooms = joinedRooms;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getJoinedRooms() {
        return joinedRooms;
    }

    public void setJoinedRooms(List<Chatroom> joinedRooms) {
        this.joinedRooms = joinedRooms;
    }
}
