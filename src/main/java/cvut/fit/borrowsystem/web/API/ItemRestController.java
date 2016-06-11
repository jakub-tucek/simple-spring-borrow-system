package cvut.fit.borrowsystem.web.API;

import cvut.fit.borrowsystem.service.ItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Tuček on 11.6.2016.
 */

@RestController
@RequestMapping("/api/items")
public class ItemRestController {
    private static final Logger log = LoggerFactory.getLogger(ItemRestController.class);

    @Autowired
    ItemManager itemManager;
}
