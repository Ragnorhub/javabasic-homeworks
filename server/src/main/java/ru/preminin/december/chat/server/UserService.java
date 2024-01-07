package ru.preminin.december.chat.server;

public interface UserService {
    String getUsernameByLoginAndPassword(String login, String password);
    String getUserRoleByName(String name);
    void createNewUser(String login, String password, String username, String role);
    boolean isLoginAlreadyExist(String login);
    boolean isUsernameAlreadyExist(String username);
}
