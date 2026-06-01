package com.joao.firstooproject.console;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Book;
import com.joao.firstooproject.entities.Client;
import com.joao.firstooproject.entities.Coupon;
import com.joao.firstooproject.entities.Order;
import com.joao.firstooproject.services.ClientService;
import com.joao.firstooproject.services.OrderService;
import com.joao.firstooproject.services.ProductService;
import com.joao.firstooproject.utils.DataReader;

import java.util.Optional;

public class Start {
    private static Client loggedClient = null;
    private static Database database = new Database();

    private static ClientService  clientService = new ClientService(database);
    private static ProductService productService = new ProductService(database);
    private static OrderService orderService = new OrderService(database);

    static void main(String[] args) {
        System.out.println("Welcome to e-Compras");

        String option = "";

        while (true) {

            if (loggedClient == null) {
                System.out.println("Enter client cpf: ");
                String cpf = "";
                cpf = DataReader.readData();
                identifyUser(cpf);
            }

            System.out.println("Choose a option");
            System.out.println("1 - Register Book");
            System.out.println("2 - Delete Book");
            System.out.println("3 - Register Notebook");
            System.out.println("4 - Delete Notebook");
            System.out.println("5 - Register Order");
            System.out.println("6 - Delete Order");
            System.out.println("7 - List products");
            System.out.println("8 - List orders");
            System.out.println("9 - Log off");
            System.out.println("10 - Exit");

            option = DataReader.readData();

            switch (option) {
                case "1":
                    Book book = DataReader.readBook();
                    productService.save(book);
                    break;
                case "2":
                    System.out.println("Enter book code");
                    String bookCode = DataReader.readData();
                    productService.delete(bookCode);
                    break;
                case "3":
                    // TODO register Notebook
                    break;
                case "4":
                    // TODO delete Notebook
                    break;
                case "5":
                    Order order = DataReader.readOrder(database);
                    Optional<Coupon> coupon = DataReader.readCoupon(database);

                    if (coupon.isPresent()) {
                        orderService.save(order, coupon.get());
                    } else {
                        orderService.save(order);
                    }
                    break;
                case "6":
                    System.out.println("Enter order code");
                    String orderCode = DataReader.readData();
                    orderService.delete(orderCode);
                    break;
                case "7":
                    productService.getAll();
                    break;
                case "8":
                    // TODO list all orders
                    break;
                case "9":
                    System.out.printf("Always come back %s!", loggedClient.getName());
                    loggedClient = null;
                    break;
                case "10":
                    System.out.println("Application closed");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

    private static void identifyUser(String cpf) {
        Optional<Client> result = clientService.getClientByCpf(cpf);

        if (result.isPresent()) {
            Client client = result.get();
            System.out.printf("Hello %s! You are logged in%n", client.getName());
            loggedClient = client;
        } else {
            System.out.println("User not registered");
            System.exit(0);
        }
    }
}
