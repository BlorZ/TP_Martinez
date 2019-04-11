package com.istv.auth.service;

import com.istv.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
