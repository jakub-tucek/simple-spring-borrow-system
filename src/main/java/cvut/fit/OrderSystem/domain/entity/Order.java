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

    private Item item;

    private User user;

    private boolean returned = false;

    public Order() {
    }

    public Order(Item item, User user) {
        this.item = item;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
