package cvut.fit.ordersystem.web;

import cvut.fit.ordersystem.service.OrderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getItems(Model model) {
        // itemManager.deleteAll();
        // itemManager.insert(new Item("Super cool test item", 55));
        model.addAttribute("avaliableItems", orderManager.findAvailableItems());
    }

}
