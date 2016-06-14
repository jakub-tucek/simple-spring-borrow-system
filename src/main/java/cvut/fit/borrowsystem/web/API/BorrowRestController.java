package cvut.fit.borrowsystem.web.API;

import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.service.BorrowManager;
import cvut.fit.borrowsystem.web.API.RestEntity.BorrowPureData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Jakub Tuček on 11.6.2016.
 */
@RestController
@RequestMapping("/api/borrows")
public class BorrowRestController {
    private static final Logger log = LoggerFactory.getLogger(BorrowRestController.class);

    @Autowired
    BorrowManager borrowManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Borrow> getActiveBorrows() {
        List<Borrow> borrows = borrowManager.findActiveBorrows();
        for (Borrow b : borrows) {
            b.getUser().setPassword("-");
        }
        return borrows;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public BorrowPureData saveBorrow(@RequestBody BorrowPureData borrowPureData) {
        System.out.println(borrowPureData);

        return borrowPureData;
    }

    @RequestMapping(value = "available/items", method = RequestMethod.GET)
    public List<Item> getAvailableItems() {
        return borrowManager.findAvailableItems();
    }


}
