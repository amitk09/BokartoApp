package org.bokarto.service;

import org.bokarto.dto.UserDTO;
import org.bokarto.model.User;

public interface UserService {

    void registerUser(UserDTO userDTO);
    User getUserByUsername(String username);
}
