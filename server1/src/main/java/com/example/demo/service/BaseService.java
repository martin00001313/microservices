package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UsersDTO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author martin
 */
@Service
public class BaseService {

    @Autowired
    private UserDAO userDAO;

    public UsersDTO generateAndGetUsers() {
        this.userDAO.create();
        this.userDAO.create();

        final Collection<UserDTO> users = this.userDAO.getUsers();
        final UsersDTO dto = new UsersDTO();
        dto.setUsers(users);
        return dto;
    }
}
