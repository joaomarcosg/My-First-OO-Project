package com.joao.firstooproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String code;
    private Client client;
    private List<Product> products;
    private double total;

    public Order() {
        this.products = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String getPurchasedOrders() {
        StringBuilder products = new StringBuilder();
        products.append("[");
        for (Product product : getProducts()) {
            products.append(product.toString());
            products.append("Qtd:");
            products.append(product.getQuantity());
            products.append(" ");
        }
        products.append("]");

        return products.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "code='" + code + '\'' +
                ", client=" + client +
                ", products=" + getPurchasedOrders() +
                ", total=" + total +
                '}';
    }
}
