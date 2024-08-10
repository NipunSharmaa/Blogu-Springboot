package com.nipun.blogz.blogapp.controller;


import com.nipun.blogz.blogapp.payload.ApiResponse;
import com.nipun.blogz.blogapp.payload.UserDto;
import com.nipun.blogz.blogapp.service.JwtService;
import com.nipun.blogz.blogapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/")
    public String createUser(@Valid  @RequestBody UserDto userDto){

        UserDto createUserDto= this.userService.createUser(userDto);
//        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
        return jwtService.generateToken(userDto.getName());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
    UserDto updatedUser= this.userService.updateUser(userDto,userId);
    return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }





}
