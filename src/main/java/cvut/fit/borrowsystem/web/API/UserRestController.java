package cvut.fit.borrowsystem.web.API;

import cvut.fit.borrowsystem.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jakub Tuček on 11.6.2016.
 */
public class UserRestController {
    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    UserManager userManager;

}
