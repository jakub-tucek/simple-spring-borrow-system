package cvut.fit.ordersystem.web;

import cvut.fit.ordersystem.domain.entity.User;
import cvut.fit.ordersystem.domain.enums.Role;
import cvut.fit.ordersystem.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jakub Tuček on 5.4.2016.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/del")
    public void deleteUsers(Model model) {
        userManager.deleteAll();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getUsers(Model model) {
        // save
        userManager.deleteAll();
        userManager.insert(new User("john", "mkyong", "password", Role.USER));
        userManager.insert(new User("john1", "mkyong1", "password", Role.USER));

       /* List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);*/

        List<User> userList = userManager.findAll();
        model.addAttribute("users", userList);
    }
}
