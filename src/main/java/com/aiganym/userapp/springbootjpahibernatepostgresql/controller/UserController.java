package com.aiganym.userapp.springbootjpahibernatepostgresql.controller;

import com.aiganym.userapp.springbootjpahibernatepostgresql.entity.User;
import com.aiganym.userapp.springbootjpahibernatepostgresql.exception.UserNoContentException;
import com.aiganym.userapp.springbootjpahibernatepostgresql.exception.UserNotFoundException;
import com.aiganym.userapp.springbootjpahibernatepostgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository ;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = new ArrayList<>();

        userRepository.findAll().forEach(userList::add);
        if (userList.isEmpty()) {
            throw new UserNoContentException("The user list is empty");
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable (value = "id") long userId) {
        Optional <User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> createUser (  @RequestBody User newUser) {
        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById (@RequestBody User updated_user, @PathVariable long id) {

        Optional<User > userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("Invalid id: " + id);
        }

        User user1 = userOptional.get();
        user1.setFirstName(updated_user.getFirstName());
        user1.setLastName(updated_user.getLastName());
        user1.setEmail(updated_user.getEmail());
        return new ResponseEntity<>(userRepository.save(user1), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById (@PathVariable long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex) {
            throw new UserNotFoundException("There is no User with id " + id);
        }
    }

    @DeleteMapping()
    public ResponseEntity<User> deleteAllUsers () {

        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        if (userList.isEmpty()) {
            throw new UserNoContentException("The User List is already empty");
        }
        userRepository.deleteAll(userList);
        return ResponseEntity.ok().build();
    }

}
