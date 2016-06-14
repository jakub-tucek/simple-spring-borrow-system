package cvut.fit.borrowsystem.web.API;

import cvut.fit.borrowsystem.domain.entity.User;
import cvut.fit.borrowsystem.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jakub Tuček on 11.6.2016.
 */

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    UserManager userManager;


    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<User> getSafeUsers() {
        List<User> users = userManager.findAll();
        for (User u : users) {
            u.setPassword("-");
        }
        return users;
    }
}
