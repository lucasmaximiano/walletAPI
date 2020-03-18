package com.wallet.service;

import java.util.Optional;

import com.wallet.entity.User;

/**
 * UserService
 */
public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);
}