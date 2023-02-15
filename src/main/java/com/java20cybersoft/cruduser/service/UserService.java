package com.java20cybersoft.cruduser.service;

import java.util.Collection;
import com.java20cybersoft.cruduser.model.User;
public interface UserService {
    public abstract void createUser(
            User user
    );
    public abstract void updateUser(
            String id,
            User user
    );
    public abstract void deleteUser(
            String id
    );
    public abstract Collection<User> getUsers();
}
