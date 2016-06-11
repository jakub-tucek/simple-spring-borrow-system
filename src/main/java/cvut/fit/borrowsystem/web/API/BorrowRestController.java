package cvut.fit.borrowsystem.web.API;

import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.service.BorrowManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "getActive", method = RequestMethod.GET)
    @ResponseBody
    public List<Borrow> getActiveBorrows(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        return borrowManager.findActiveOrders();
    }
}
