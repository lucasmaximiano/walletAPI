package com.wallet.controller;

import javax.validation.Valid;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();

        User user = service.save(this.convertDtoToEntity(dto));

        response.setData(this.convertEntityToDto(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private User convertDtoToEntity(UserDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());

        return user;
    }

    private UserDTO convertEntityToDto(User user) {
        UserDTO dto = new UserDTO();

        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());

        return dto;
    }

}