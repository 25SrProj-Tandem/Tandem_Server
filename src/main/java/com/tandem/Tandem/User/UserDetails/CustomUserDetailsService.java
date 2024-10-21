package com.tandem.Tandem.User.UserDetails;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tandem.Tandem.User.User;
import com.tandem.Tandem.User.UserRepo;

import java.util.Arrays;

// Handles retrieving the current user from the database based off custom parameters (the email in this case)
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepository;

    public CustomUserDetailsService(UserRepo userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new CustomUserDetails(user.getEmail(), user.getPassword(), authorities(), user.getFirstName(),
                user.getLastName());
    }

    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
