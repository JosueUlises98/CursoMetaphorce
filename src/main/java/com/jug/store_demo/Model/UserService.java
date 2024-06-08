package com.jug.store_demo.Model;

import com.jug.store_demo.Exceptions.RequestException;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // POST
    public void addUser(User user) {
        Optional<User> userIsPresent = userRepository.findByEmail(user.getEmail());

        if (userIsPresent.isPresent()) {
            throw new RequestException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Long id) {
        boolean userExists = userRepository.existsById(id);

        if (!userExists) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }
}
