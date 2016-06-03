package cvut.fit.ordersystem.service;

import cvut.fit.ordersystem.domain.UserRepository;
import cvut.fit.ordersystem.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jakub Tuček on 10.4.2016.
 */
@Service
public class UserManager {
    @Autowired
    UserRepository userRepository;

    List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    User findOne(String id) {
        return userRepository.findOne(id);
    }

    public User insert(User s) {
        return userRepository.insert(s);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
