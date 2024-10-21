package com.tandem.Tandem.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tandem.Tandem.User.FrontendCommunication.UserDto;

// Interfaces our custom user information to the JpaRepository functions in order to pull user info from the database
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User save(UserDto userDto);
}
