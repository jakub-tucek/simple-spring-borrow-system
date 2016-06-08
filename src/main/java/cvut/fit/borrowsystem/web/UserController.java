package cvut.fit.borrowsystem.web;

import cvut.fit.borrowsystem.domain.entity.User;
import cvut.fit.borrowsystem.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "del/all", method = RequestMethod.GET)
    public void deleteUsers(Model model) {
        userManager.deleteAll();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getUsers(Model model) {
        // save
        //userManager.deleteAll();
        // userManager.insert(new User("john", "mkyong", "password", Role.USER));
        // userManager.insert(new User("john1", "mkyong1", "password", Role.USER));

       /* List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);*/

        List<User> userList = userManager.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("userSeed", new User());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userSeed") User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("type", "success");
        redirectAttributes.addFlashAttribute("message", "Successfully added.");
        userManager.insert(user);

        return "redirect:/users";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable(value = "id") String id, Model model, RedirectAttributes redirectAttributes) {
        User i = userManager.findOne(id);
        if (i == null) {
            redirectAttributes.addFlashAttribute("css", "error");
            redirectAttributes.addFlashAttribute("message", "User does not exist..");
        } else {
            userManager.delete(i);
        }
        return "redirect:/users";
    }
}
