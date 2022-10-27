package Entities;

public class User {
    String Login;
    String Password;

    public User(String login, String password) {
        Login = login;
        Password = password;
    }

    public String GetLogin() {
        return Login;
    }

    public String GetPassword() {
        return Password;
    }
}
