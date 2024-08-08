package jfx.cmnbtwcontroller;

import java.io.IOException;

public class User {
    private final String username;
    private String password;
    private final String fullName;
    private String dateOfBirth;
    private String gender;
    public User(String username, String password, String fullName, String dateOfBirth, String gender) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.fullName = "";
        this.dateOfBirth = "";
        this.gender = "";
    }
    public String getFullName() {
        return fullName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getGender() {
        return gender;
    }
    public void setPassword(String oldPassword, String newPassword) throws IOException{
        if (oldPassword.equals(password)) {
            password = newPassword;
        }
        else throw new IOException("Old password does not match");
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
