package com.java20cybersoft.cruduser.controller;

import com.java20cybersoft.cruduser.model.User;
import com.java20cybersoft.cruduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(
                userService.getUsers(), HttpStatus.OK
        );
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(
            @RequestBody User user
    )
    {
        userService.createUser(user);
        return new ResponseEntity<>("User is created successfully",
                HttpStatus.CREATED);
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(
            @PathVariable("id") String id,
//            @PathVariable("email") String email,
            @RequestBody User user
    ) {
        userService.updateUser(id, user);

        return new ResponseEntity<>(
                "User is updated successsfully", HttpStatus.OK
        );
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(
            @PathVariable("id") String id
    ) {
        userService.deleteUser(id);
        return new ResponseEntity<>(
                "User is deleted successfully", HttpStatus.OK
        );
    }

}
