package com.informatics.cscb869f2022week5.services.implementations;

import com.informatics.cscb869f2022week5.data.entity.User;
import com.informatics.cscb869f2022week5.data.repository.UserRepository;
import com.informatics.cscb869f2022week5.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
