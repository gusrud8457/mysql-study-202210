package com.study.springboot202210junil.web.controller;

import com.study.springboot202210junil.service.UserService;
import com.study.springboot202210junil.web.dto.UserDto;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
 //     return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto); // 빌더 형식
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }

}
