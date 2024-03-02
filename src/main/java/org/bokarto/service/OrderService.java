package org.bokarto.service;

import org.bokarto.model.Book;
import org.bokarto.model.Order;
import org.bokarto.model.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, List<Book> books);
}
