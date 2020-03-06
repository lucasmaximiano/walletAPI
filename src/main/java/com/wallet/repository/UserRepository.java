package com.wallet.repository;

import java.util.Optional;

import com.wallet.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailEquals(String email);
}