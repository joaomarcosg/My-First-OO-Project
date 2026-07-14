package com.joao.firstooproject.services;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Coupon;
import com.joao.firstooproject.entities.Order;
import com.joao.firstooproject.entities.Product;

import java.time.LocalDate;
import java.util.List;

public class OrderService {
    private Database database;

    public OrderService(Database database) {
        this.database = database;
    }

    private double calculateTotal(List<Product> products, Coupon coupon) {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculateShipping();
        }

        if (coupon != null) {
            return total * (1 - coupon.getDiscount());
        } else {
            return total;
        }
    }

    public void save(Order newOrder) {
        save(newOrder, null);
    }

    public void save(Order newOrder, Coupon coupon) {
        String code = "PE%4d%2d%004d";
        LocalDate today = LocalDate.now();
        code = String.format(code, today.getYear(), today.getMonthValue(), database.getOrders().length);

        newOrder.setCode(code);
        newOrder.setTotal(calculateTotal(newOrder.getProducts(), coupon));
        database.addOrder(newOrder);
        System.out.println("Order saved successfully");
    }

    public void getAll() {
        if (database.getOrders().length == 0) {
            System.out.println("There are no orders");
        } else {
            for (Order order : database.getOrders()) {
                System.out.println(order.toString());
            }
        }
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
