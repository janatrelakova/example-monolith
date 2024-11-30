package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class UserRepository {
    private final ArrayList<User> users = new ArrayList<>(
            new ArrayList<>() {{
                add(new User(1, "User"));
                add(new User(2, "User"));
                add(new User(3, "User"));
            }}
    );

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User update(User user) {
        for (User c : users) {
            if (c.getId() == user.getId()) {
                c.setName(user.getName());
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public Optional<User> findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public ArrayList<User> findAll() {
        return users;
    }

    public User findByName(String username) {
        return users.stream().filter(user -> user.getName().equals(username)).findFirst().orElse(null);
    }
}