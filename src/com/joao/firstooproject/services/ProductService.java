package com.joao.firstooproject.services;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Product;

import java.util.Objects;
import java.util.Optional;

public class ProductService {
    private Database database;

    public ProductService(Database database) {
        this.database = database;
    }

    public void save(Product newProduct) {
        String code = "PR%4d";
        code = String.format(code, database.getProducts().length);
        newProduct.setCode(code);

        boolean repeatedProduct = false;
        for (Product product : database.getProducts()) {
            if (Objects.equals(product.getCode(), newProduct.getCode())) {
                repeatedProduct = true;
                System.out.println("Product already exists");
                break;
            }
        }

        if (!repeatedProduct) {
            this.database.addProduct(newProduct);
            System.out.println("Product added successfully");
        }

    }

    public void delete(String code) {
        int position = -1;
        for (int i = 0; i < database.getProducts().length; i++) {
            Product product = database.getProducts()[i];
            if (product.getCode().equals(code)) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            database.removeProduct(position);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product do not exists");
        }
    }

    public Optional<Product> getProductByCode(String code) {
        for (Product product : database.getProducts()) {
            if (product.getCode().equalsIgnoreCase(code)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void getAll() {
        if (database.getProducts().length == 0) {
            System.out.println("No products registered");
        } else {
            for (Product product : database.getProducts()) {
                System.out.println(product.toString());
            }
        }
    }
}
