package cvut.fit.borrowsystem.service;

import cvut.fit.borrowsystem.domain.BorrowRepository;
import cvut.fit.borrowsystem.domain.entity.Book;
import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Borrow manager class.
 * Created by Jakub Tuček on 10.4.2016.
 */
@Service
public class BorrowManager {

    @Autowired
    BorrowRepository orderRepository;

    @Autowired
    ItemManager itemManager;

    @Autowired
    BookManager bookManager;


    public List<Borrow> findOrdersForUser(User user) {
        return orderRepository.findByUser(user);
    }

    public List<Borrow> findAvailableBooks() {

        return null;
    }

    /**
     * Finds available items and books
     *
     * @return List of Items for borrowing
     */
    public List<Item> findAvailableItems() {
        List<Borrow> notReturnedBorrows = orderRepository.findByReturned(false);
        HashMap<Item, Integer> borrowedItems = new HashMap<Item, Integer>();
        List<Item> allItems = itemManager.findAll();
        List<Book> allBooks = bookManager.findAll();
        List<Item> availableItems = new ArrayList<>();

        for (Item i : allItems) {
            long count = orderRepository.countBorrowedByItem(i, false);

            if (i.getCount() > count) {
                availableItems.add(i);
            }
        }
        for (Book b : allBooks) {
            long count = orderRepository.countBorrowedByItem(b, false);
            if (b.getCount() > count) {
                availableItems.add(b);
            }
        }
        return availableItems;
    }

    public List<Item> findBorrowedItems() {
        List<Borrow> notReturnedBorrows = orderRepository.findByReturned(false);
        List<Item> borrowedItems = new ArrayList<>();
        for (Borrow o : notReturnedBorrows) {
            borrowedItems.add(o.getItem());
        }
        return borrowedItems;
    }

    public List<Borrow> findActiveOrders() {
        return orderRepository.findByReturned(false);
    }

    public void insert(Borrow borrow) {
        orderRepository.insert(borrow);
    }
}
