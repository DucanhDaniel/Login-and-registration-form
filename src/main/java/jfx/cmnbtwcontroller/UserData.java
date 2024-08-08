package jfx.cmnbtwcontroller;
import java.util.ArrayList;
public class UserData {
    private static final ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) throws IllegalArgumentException {
        if (users.contains(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        else users.add(user);
    }
    public static boolean checkValid(User user) {
        return users.contains(user);
    }
    public static User loginOK(User user) {
        for (User element : users) {
            if (user.getUsername().equals(element.getUsername())
            && user.getPassword().equals(element.getPassword()))
                return element;
        }
        return null;
    }
}
