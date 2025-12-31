package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    public record UserResponse (long id, String name){}


    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest req) {
        User user = userService.create(req.name());
        return new UserResponse(user.getId(), user.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable long id) {
        User user = userService.find(id);
        if (user == null) return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> changeName(
            @PathVariable long id,
            @RequestBody ChangeNameRequest req
    ) {
        User user = userService.changeName(id, req.name());
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    public record CreateUserRequest(String name) {}
    public record ChangeNameRequest(String name){}

}
