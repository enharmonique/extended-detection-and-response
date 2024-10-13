package xdr.backend.xdr_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xdr.backend.xdr_backend.dto.UserDTO;
import xdr.backend.xdr_backend.model.User;
import xdr.backend.xdr_backend.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/xdr")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        User user = userService.login(userDTO.getUsername(), userDTO.getPassword());
        if (user != null) {
            UserDTO responseDTO = new UserDTO(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        User newUser = userService.registerUser(userDTO.getUsername(), userDTO.getPassword());
        if (newUser != null) {
            UserDTO responseDTO = new UserDTO(newUser.getUsername(), newUser.getPassword());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(400).body(Map.of("message", "Username already taken"));
        }
    }
}
