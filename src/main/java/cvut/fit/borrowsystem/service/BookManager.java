package cvut.fit.borrowsystem.service;

import cvut.fit.borrowsystem.domain.BookRepository;
import cvut.fit.borrowsystem.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Manager layer for item
 * Created by Jakub Tuček on 10.4.2016.
 */

@Service
public class BookManager {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(String id) {
        return bookRepository.findOne(id);
    }

    public Book insert(Book s) {
        return bookRepository.insert(s);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }


    public boolean isItemNameUsed(String itemName) {
        return bookRepository.findByItemName(itemName) != null;
    }

    public void delete(Book i) {
        bookRepository.delete(i);
    }
}
