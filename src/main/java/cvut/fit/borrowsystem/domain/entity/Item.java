package cvut.fit.borrowsystem.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Item entity
 * Created by Jakub Tuček on 04/04/16.
 */
@Document
public class Item {
    @Id
    private String id;

    @Indexed(unique = true)
    private String itemName;

    private int count;

    public Item() {
    }

    public Item(String itemName, int count) {
        this.count = count;
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
