package cvut.fit.ordersystem.web;

import cvut.fit.ordersystem.domain.entity.Item;
import cvut.fit.ordersystem.service.ItemManager;
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

/**
 * Item controller.
 * Created by Jakub Tuček on 5.4.2016.
 */
@Controller
@RequestMapping("/items")
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    ItemManager itemManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getItems(Model model) {
        // itemManager.deleteAll();
        // itemManager.insert(new Item("Super cool test item", 55));
        model.addAttribute("items", itemManager.findAll());
        model.addAttribute("itemSeed", new Item());

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("itemSeed") Item item, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("itemName", item.getItemName());
        model.addAttribute("age", item.getCount());

        if (itemManager.isItemNameUsed(item.getItemName())) {
            model.addAttribute("items", itemManager.findAll());
            result.rejectValue("itemName", "itemName.notvalid", "Item name used");
            return "items";

        } else {
            redirectAttributes.addFlashAttribute("type", "success");
            redirectAttributes.addFlashAttribute("message", "Successfully added.");
            itemManager.insert(item);
        }
        return "redirect:/items";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable(value = "id") String id, Model model, RedirectAttributes redirectAttributes) {
        Item i = itemManager.findOne(id);
        if (i == null) {
            redirectAttributes.addFlashAttribute("css", "error");
            redirectAttributes.addFlashAttribute("message", "Item does not exist..");
        } else {
            itemManager.delete(i);
        }
        return "redirect:/items";
    }

}
