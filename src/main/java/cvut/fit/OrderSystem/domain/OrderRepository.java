package cvut.fit.ordersystem.domain;

import cvut.fit.ordersystem.domain.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jakub Tuček on 2.4.2016.
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
