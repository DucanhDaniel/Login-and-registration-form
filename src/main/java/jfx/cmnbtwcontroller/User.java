package jfx.cmnbtwcontroller;

import java.io.IOException;

public class User {
    private final String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String oldPassword, String newPassword) throws IOException{
        if (oldPassword.equals(password)) {
            password = newPassword;
        }
        else throw new IOException("Old password does not match");
    }

    @Override
    public boolean equals(Object other) throws IllegalArgumentException  {
        if (other != null && other.getClass().equals(User.class)) {
            User otherUser = (User) other;
            return username.equals(otherUser.getUsername());
        }
        else
            throw new IllegalArgumentException("Object is not a User");
    }
}
