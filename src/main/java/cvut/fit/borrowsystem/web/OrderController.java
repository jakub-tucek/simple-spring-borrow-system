package cvut.fit.borrowsystem.web;

import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.Order;
import cvut.fit.borrowsystem.service.BookManager;
import cvut.fit.borrowsystem.service.OrderManager;
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
 * Controller for borrowing and returning items.
 * Created by Jakub Tuček on 10.4.2016.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderManager orderManager;

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getItems(Model model) {
        // itemManager.deleteAll();
        // itemManager.insert(new Item("Super cool test item", 55));
        model.addAttribute("avaliableItems", orderManager.findAvailableItems());

        model.addAttribute("orders", orderManager.findActiveOrders());
        model.addAttribute("users", userManager.findAll());
        model.addAttribute("orderSeed", new Order());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String borrowItem(@ModelAttribute("orderSeed") Order order, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        List<Item> availableItems = orderManager.findAvailableItems();
        if (availableItems.contains(order.getItem())) {
            redirectAttributes.addFlashAttribute("type", "error");
            redirectAttributes.addFlashAttribute("message", "Item not available.");
        } else {
            redirectAttributes.addFlashAttribute("type", "success");
            redirectAttributes.addFlashAttribute("message", "Successfully borrowed.");
            if (order.getUser() == null || order.getItem() == null) {
                System.out.println("item or user not set");
                System.out.println(order.getUser());
                System.out.println(order.getItem());
            } else {

                orderManager.insert(order);
            }
        }


        return "redirect:/orders";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String getOrdersForUser(@PathVariable(value = "userId") String userId, Model model, RedirectAttributes redirectAttributes) {


        return "redirect:/orders";
    }

}
