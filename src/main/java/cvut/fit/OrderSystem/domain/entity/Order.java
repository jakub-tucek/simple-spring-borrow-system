package cvut.fit.ordersystem.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Order entity
 * Created by Jakub Tuček on 04/04/16.
 */
@Document
public class Order {

    @Id
    private String id;

    private String itemId;

    private String userId;

    public Order() {
    }

    public Order(String itemId, String userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
