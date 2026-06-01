package com.joao.firstooproject.entities;

public class Order {
    private String code;
    private Client client;
    private Product product;
    private double total;

    public Order() {}

    public Order(String code, Client client, Product product, double total) {
        this.code = code;
        this.client = client;
        this.product = product;
        this.total = total;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
