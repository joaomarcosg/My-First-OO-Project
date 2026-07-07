package com.joao.firstooproject.utils;

import com.joao.firstooproject.constants.Genre;
import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Book;
import com.joao.firstooproject.entities.Coupon;
import com.joao.firstooproject.entities.Order;
import com.joao.firstooproject.entities.Product;
import com.joao.firstooproject.services.ProductService;

import java.util.Optional;
import java.util.Scanner;

public final class DataReader {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String readData() {
        return scanner.nextLine();
    }

    public static Book readBook() {
        System.out.println("Registering book..");
        Book book = new Book();

        System.out.println("Enter name:");
        String name = readData();
        book.setName(name);

        System.out.println("Enter genre:");
        String genre = readData();
        book.setGenre(Genre.valueOf(genre.toUpperCase()));

        System.out.println("Enter price:");
        String price = readData();
        book.setPrice(Double.parseDouble(price));

        return book;
    }

    public static Order readOrder(Database database) {
        ProductService productService = new ProductService(database);

        System.out.println("Registering order..");
        Order order = new Order();

        String option = "s";
        do {
            System.out.println("Enter product code(Book/Notebook:");
            String code = readData();

            Optional<Product> result = productService.getProductByCode(code);
            if (result.isPresent()) {
                Product product = result.get();

                System.out.println("Enter quantity:");
                String quantity = readData();
                product.setQuantity(Integer.parseInt(quantity));

                order.getProducts().add(product);
            } else {
                System.out.println("Invalid product code. Choose a valid product code");
            }

            System.out.println("Do you want to select another product?");
            option = readData();
        } while (option.equals("s"));

        return  order;
    }

    public static Optional<Coupon> readCoupon(Database database) {
        System.out.println("Choose between: COUPON2, COUPON5, COUPON7. Or leave it empty");

        String discount = readData();

        for (Coupon coupon : database.getCoupons()) {
            if (coupon.getCode().equalsIgnoreCase(discount)) {
                return Optional.of(coupon);
            }
        }
        return Optional.empty();
    }
}
