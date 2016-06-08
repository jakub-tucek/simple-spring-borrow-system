package cvut.fit.borrowsystem.domain;

import cvut.fit.borrowsystem.domain.entity.Order;
import cvut.fit.borrowsystem.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jakub Tuček on 2.4.2016.
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUser(@Param("user") User user);

    List<Order> findByReturned(@Param("returned") boolean returned);

}
