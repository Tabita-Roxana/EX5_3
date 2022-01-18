package com.example.demo.user;

class UserNotFoundException extends RuntimeException {

  UserNotFoundException(Integer id) {
    super("Could not find user " + id);
  }
}