package com.joao.firstooproject.services;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Coupon;
import com.joao.firstooproject.entities.Order;
import com.joao.firstooproject.entities.Product;

import java.util.List;

public class OrderService {
    private Database database;

    public OrderService(Database database) {
        this.database = database;
    }

    public void delete(String code) {
        int exclusionOrder = -1;
        for (int i = 0; i < database.getOrders().length; i++) {
            Order order =  database.getOrders()[i];
            if (order.getCode().equals(code)) {
                exclusionOrder = i;
                break;
            }
        }

        if (exclusionOrder != -1) {
            database.removeOrder(exclusionOrder);
            System.out.println("Order deleted successfully");
        } else {
            System.out.println("Order not found");
        }
    }
}
