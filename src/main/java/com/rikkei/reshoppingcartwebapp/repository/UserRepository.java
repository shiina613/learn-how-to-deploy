package com.rikkei.reshoppingcartwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.reshoppingcartwebapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
