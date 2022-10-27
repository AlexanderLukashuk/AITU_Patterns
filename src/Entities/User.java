package Entities;

public class User {
    String Login;
    String Password;

    public User(String login, String password) {
        Login = login;
        Password = password;
    }

    String GetLogin() {
        return Login;
    }

    String GetPassword() {
        return Password;
    }
}
