package com.example.demo.dto;

import java.util.Collection;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author martin
 */
@NoArgsConstructor
@Data
public class UsersDTO {

    private Collection<UserDTO> users;
}
