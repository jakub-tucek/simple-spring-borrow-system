package cvut.fit.ordersystem.service;

import cvut.fit.ordersystem.domain.OrderRepository;
import cvut.fit.ordersystem.domain.entity.Item;
import cvut.fit.ordersystem.domain.entity.Order;
import cvut.fit.ordersystem.domain.entity.User;
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

    public List<Order> findOrdersForUser(User user) {
        return orderRepository.findByUser(user);
    }

    public List<Order> findAvailableBooks() {

        return null;
    }

    public List<Item> findAvailableItems() {
        List<Order> notReturnedOrders = orderRepository.findByReturned(false);
        HashMap<Item, Integer> borrowedItems = new HashMap<Item, Integer>();
        List<Item> availableItems = new ArrayList<Item>();

        for (Order o : notReturnedOrders) {
            if (borrowedItems.containsKey(o.getItem())) {
                Integer k = borrowedItems.get(o);
                k++;
                borrowedItems.put(o.getItem(), k);
            } else {
                borrowedItems.put(o.getItem(), 1);
            }
        }

        borrowedItems.forEach((k, v) -> {
            if (k.getCount() < v) availableItems.add(k);
        });

        return availableItems;
    }
}
