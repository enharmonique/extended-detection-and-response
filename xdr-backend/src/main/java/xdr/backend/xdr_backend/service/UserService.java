package xdr.backend.xdr_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xdr.backend.xdr_backend.model.User;
import xdr.backend.xdr_backend.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String username, String password) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    public User registerUser(String username, String password) {
        Optional<User> existingUser = userRepo.findByUsername(username);
        if (existingUser.isPresent()) {
            return null;
        }

        User newUser = new User(username, password);
        userRepo.save(newUser);
        return newUser;
    }
}
