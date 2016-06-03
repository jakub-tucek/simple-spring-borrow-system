package cvut.fit.ordersystem.domain;

import cvut.fit.ordersystem.domain.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Item repository.
 * Created by Jakub Tuček on 2.4.2016.
 */

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByItemName(@Param("itemName") String itemName);
}
