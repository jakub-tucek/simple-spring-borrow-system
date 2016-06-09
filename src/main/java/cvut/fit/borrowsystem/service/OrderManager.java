package cvut.fit.borrowsystem.service;

import cvut.fit.borrowsystem.domain.ItemRepository;
import cvut.fit.borrowsystem.domain.OrderRepository;
import cvut.fit.borrowsystem.domain.entity.Book;
import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.Order;
import cvut.fit.borrowsystem.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Order manager class.
 * Created by Jakub Tuček on 10.4.2016.
 */
@Service
public class OrderManager {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemManager itemManager;

    @Autowired
    BookManager bookManager;


    public List<Order> findOrdersForUser(User user) {
        return orderRepository.findByUser(user);
    }

    public List<Order> findAvailableBooks() {

        return null;
    }

    /**
     * Finds available items and books
     * @return List of Items for borrowing
     */
    public List<Item> findAvailableItems() {
        List<Order> notReturnedOrders = orderRepository.findByReturned(false);
        HashMap<Item, Integer> borrowedItems = new HashMap<Item, Integer>();
        List<Item> allItems = itemManager.findAll();
        List<Book> allBooks = bookManager.findAll();
        List<Item> availableItems = new ArrayList<>();

        for (Item i : allItems) {
            long count = orderRepository.countBorrowedByItem(i,false);

            if (i.getCount() > count) {
                availableItems.add(i);
            }
        }
        for (Book b : allBooks) {
            long count = orderRepository.countBorrowedByItem(b,false);
            if (b.getCount() > count) {
                availableItems.add(b);
            }
        }
        return availableItems;
    }

    public List<Item> findBorrowedItems() {
        List<Order> notReturnedOrders = orderRepository.findByReturned(false);
        List<Item> borrowedItems = new ArrayList<>();
        for (Order o : notReturnedOrders) {
            borrowedItems.add(o.getItem());
        }
        return borrowedItems;
    }

    public List<Order> findActiveOrders() {
        return orderRepository.findByReturned(false);
    }
}
