package com.tandem.Tandem.User.UserService;

import com.tandem.Tandem.User.User;
import com.tandem.Tandem.User.FrontendCommunication.UserDto;

public interface UserService {
    User findByUsername(String username);

    User save(UserDto userDto);

}
