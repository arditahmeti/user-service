package org.springframework.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.userservice.model.User;
import org.springframework.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.net.URI;

/**
 * User controller
 *
 */
@RestController
@RequestMapping("/users")
@Api
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation("Get all users")
    public ResponseEntity getUsers(@RequestParam(required = false) String firstName) {
        return ResponseEntity.ok(userService.getAllUsers(firstName));
    }

    @GetMapping("/{id}")
    @ApiOperation("Get user by id")
    public ResponseEntity getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id).orElseThrow(() -> new RuntimeException("User doesn't exists.")));
    }

    @PostMapping
    @ApiOperation("Store a user")
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.created(URI.create("")).body(userService.insertUser(user));
    }

    @PutMapping
    @ApiOperation("Update a user")
    public ResponseEntity updateUser(@RequestBody User user) {
        return ResponseEntity.created(URI.create("")).body(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a user by id")
    public ResponseEntity deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
