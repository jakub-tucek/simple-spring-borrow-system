package cvut.fit.borrowsystem.service;

import cvut.fit.borrowsystem.domain.BorrowRepository;
import cvut.fit.borrowsystem.domain.entity.Book;
import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(BorrowManager.class);

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    ItemManager itemManager;

    @Autowired
    BookManager bookManager;


    public List<Borrow> findOrdersForUser(User user) {
        return borrowRepository.findByUser(user);
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
        List<Borrow> notReturnedBorrows = borrowRepository.findByReturned(false);
        HashMap<Item, Integer> borrowedItems = new HashMap<Item, Integer>();
        List<Item> allItems = itemManager.findAll();
        List<Book> allBooks = bookManager.findAll();
        List<Item> availableItems = new ArrayList<>();

        for (Item i : allItems) {
            long count = borrowRepository.countBorrowedByItemAndReturned(i,false);
//            log.info(borrows.toString());
            if (i.getCount() > count) {
                availableItems.add(i);
            }
        }
        return availableItems;
    }

    public List<Item> findBorrowedItems() {
        List<Borrow> notReturnedBorrows = borrowRepository.findByReturned(false);
        List<Item> borrowedItems = new ArrayList<>();
        for (Borrow o : notReturnedBorrows) {
            borrowedItems.add(o.getItem());
        }
        return borrowedItems;
    }

    public List<Borrow> findActiveOrders() {
        return borrowRepository.findByReturned(false);
    }

    public void insert(Borrow borrow) {
        borrowRepository.insert(borrow);
    }

    public Borrow findOne(String borrowId) {
        return borrowRepository.findOne(borrowId);
    }

    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

}
