package com.tandem.Tandem.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tandem.Tandem.User.User;
import com.tandem.Tandem.User.UserRepo;
import com.tandem.Tandem.User.FrontendCommunication.UserDto;

// Implementation of UserService. Needed to save and find people by email/username
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepo userRepository;

    public UserServiceImpl(UserRepo userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(), userDto.getLastName());
        return userRepository.save(user);
    }

}
