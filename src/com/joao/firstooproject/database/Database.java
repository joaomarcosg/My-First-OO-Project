package com.joao.firstooproject.database;

import com.joao.firstooproject.entities.Client;
import com.joao.firstooproject.entities.Coupon;
import com.joao.firstooproject.entities.Order;
import com.joao.firstooproject.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Product> products;
    private List<Order> orders;
    private List<Coupon> coupons;
    private Client client;

    public Database() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.client = new Client();

        this.coupons = new ArrayList<>();
        coupons.add(new Coupon("COUPON2", 2));
        coupons.add(new Coupon("COUPON5", 5));
        coupons.add(new Coupon("COUPON7", 7));
    }

    public Client getClient() {
        return this.client;
    }

    public void addClient(Client client) {
        this.client = client;
    }

    public Coupon[] getCoupons() {
        return coupons.toArray(new Coupon[coupons.size()]);
    }

    public Order[] getOrders() {
        return orders.toArray(new Order[orders.size()]);
    }

    public Product[] getProducts() {
        return products.toArray(new Product[products.size()]);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int position) {
        products.remove(position);
    }

    public void removeProduct(Product product) {this.products.remove(product);}

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int position) {
        orders.remove(position);
    }
}
