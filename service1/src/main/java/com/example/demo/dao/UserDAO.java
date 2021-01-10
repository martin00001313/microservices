package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author martin
 */
@Service
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public UserDTO create() {
        final User user = this.userRepository.save(new User());
        return new UserDTO(user.getId());
    }

    public List<UserDTO> getUsers() {
        return this.userRepository.findAll()
                .stream().map(u -> new UserDTO(u.getId())).collect(Collectors.toList());
    }
}
