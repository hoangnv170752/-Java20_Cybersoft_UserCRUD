package com.java20cybersoft.cruduser.service;

import com.java20cybersoft.cruduser.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    private static Map<String, User> userRepo = new HashMap<>();
    static {
        User hoang = new User();
        hoang.setId("1");
        hoang.setEmail("hoang1@gmail.com");
        hoang.setPassword("123");
        userRepo.put(hoang.getId(), hoang);
        User akashi = new User();
        akashi.setId("2");
        akashi.setEmail("hoang2@gmail.com");
        akashi.setPassword("456");
        userRepo.put(akashi.getId(), akashi);
    }
    @Override
    public void createUser(User user) {
        userRepo.put(user.getId(), user);
    }

    @Override
    public void updateUser(String id, User user) {
        userRepo.remove(id);
        user.setId(id);
        userRepo.put(id, user);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.remove(id);
    }

    @Override
    public Collection<User> getUsers() {
        return userRepo.values();
    }
}
