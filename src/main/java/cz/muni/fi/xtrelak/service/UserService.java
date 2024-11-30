package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.User;
import cz.muni.fi.xtrelak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByName(String username) {
        return userRepository.findByName(username);
    }
}