package org.bokarto.controller;

import org.bokarto.dto.OrderDTO;
import org.bokarto.model.Book;
import org.bokarto.model.Order;
import org.bokarto.model.User;
import org.bokarto.service.BookService;
import org.bokarto.service.OrderService;
import org.bokarto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    // Order-related endpoints


    @Autowired
    private OrderService orderService;
    private UserService userService;
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        User user = userService.getUserByUsername(orderDTO.getUsername());
        List<Book> books = orderDTO.getBookIds()
                .stream()
                .map(bookService::getBookById)
                .collect(Collectors.toList());

        Order order = orderService.createOrder(user, books);
        return ResponseEntity.ok("Order created successfully. Order ID: " + order.getId());
    }
}
