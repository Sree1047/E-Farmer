package com.mitron.onlinegrocery.service;

import java.util.List;

import com.mitron.onlinegrocery.domain.entities.enumeration.Status;
import com.mitron.onlinegrocery.domain.models.service.OrderServiceModel;

public interface OrderService {

    void createOrder(OrderServiceModel orderServiceModel);

    List<OrderServiceModel> findAllOrders();

    List<OrderServiceModel> findOrdersByCustomer(String username);

    OrderServiceModel findOrderById(String id);

    List<OrderServiceModel> findOrdersByStatus(Status status);

    void changeOrderStatus(String id);

    List<OrderServiceModel> findOrdersByCustomerAndStatus(String customerName, Status status);
    void acceptOrder(String orderId);
    
    void shipOrder(String orderId);
}
