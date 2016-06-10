package cvut.fit.borrowsystem.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Borrow entity
 * Created by Jakub Tuček on 04/04/16.
 */
@Document
public class Borrow {

    @Id
    private String id;

    @DBRef
    private Item item;

    @DBRef
    private User user;

    private boolean returned = false;

    public Borrow() {
    }

    public Borrow(Item item, User user) {
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
