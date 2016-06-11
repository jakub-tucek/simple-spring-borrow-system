package cvut.fit.borrowsystem.web;

import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.service.BorrowManager;
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
import java.util.Objects;

/**
 * Controller for borrowing and returning items.
 * Created by Jakub Tuček on 10.4.2016.
 */
@Controller
@RequestMapping("/borrows")
public class BorrowController {
    private static final Logger log = LoggerFactory.getLogger(BorrowController.class);

    @Autowired
    BorrowManager borrowManager;

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getItems(Model model) {
        // itemManager.deleteAll();
        // itemManager.insert(new Item("Super cool test item", 55));
        model.addAttribute("availableItems", borrowManager.findAvailableItems());

        model.addAttribute("borrows", borrowManager.findActiveOrders());
        model.addAttribute("users", userManager.findAll());
        model.addAttribute("borrowSeed", new Borrow());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String borrowItem(@ModelAttribute("borrowSeed") Borrow borrow, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        List<Item> availableItems = borrowManager.findAvailableItems();

        boolean itemFound = false;
        if (borrow.getItem() == null) {
            log.error("item  not set");
            return "redirect:/borrows";
        }
        for (Item o : availableItems) {
            if (Objects.equals(o.getId(), borrow.getItem().getId())) {
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            redirectAttributes.addFlashAttribute("type", "error");
            redirectAttributes.addFlashAttribute("message", "Item not available.");
        } else {
            redirectAttributes.addFlashAttribute("type", "success");
            redirectAttributes.addFlashAttribute("message", "Successfully borrowed.");
            if (borrow.getUser() == null || borrow.getItem() == null) {
                log.error("item or user not set");
            } else {
                borrowManager.insert(borrow);
            }
        }


        return "redirect:/borrows";
    }

    @RequestMapping(value = "/return/{borrowId}", method = RequestMethod.GET)
    public String returnItem(@PathVariable(value = "borrowId") String borrowId, Model model, RedirectAttributes redirectAttributes) {
        Borrow o = borrowManager.findOne(borrowId);

        System.out.println("returning item");

        if (o == null || o.isReturned()) {
            redirectAttributes.addFlashAttribute("type", "error");
            redirectAttributes.addFlashAttribute("message", "Item doesnt exist or was borrowed.");
        } else {
            o.setReturned(true);
            borrowManager.save(o);
            redirectAttributes.addFlashAttribute("type", "success");
            redirectAttributes.addFlashAttribute("message", "Item was returned.");
        }
        return "redirect:/borrows";
    }

}
