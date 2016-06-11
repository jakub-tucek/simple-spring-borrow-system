package cvut.fit.borrowsystem.domain.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jakub Tuček on 03/06/16.
 */
@Document(collection = "item")
public class Book extends Item {

    private int isbn;

    public Book() {
    }

    public Book(String itemName, int count, int isbn) {
        super(itemName, count);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


}
