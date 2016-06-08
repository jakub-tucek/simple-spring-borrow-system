package cvut.fit.borrowsystem.service;

import cvut.fit.borrowsystem.domain.UserRepository;
import cvut.fit.borrowsystem.domain.entity.User;
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

    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    public User insert(User u) {
        return userRepository.insert(u);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void delete(User u) {
        userRepository.delete(u);
    }
}
