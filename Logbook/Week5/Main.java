package Logbook.Week5;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void printProductDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}

class StockList {
    private ArrayList<Product> products;

    public StockList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {
        Product productToRemove = findProductById(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void displayStockList() {
        if (products.isEmpty()) {
            System.out.println("No products in stock.");
        } else {
            for (Product p : products) {
                p.printProductDetails();
            }
        }
    }
}

class StockDemo {
    public void run(StockList stockList) {
        testAddProducts(stockList);
        testRemoveProduct(stockList);
        testFindProduct(stockList);
        testPrintProducts(stockList);
    }

    public void testAddProducts(StockList stockList) {
        Product product1 = new Product(1, "Product A", 10);
        Product product2 = new Product(2, "Product B", 20);
        Product product3 = new Product(3, "Product C", 30);

        stockList.addProduct(product1);
        stockList.addProduct(product2);
        stockList.addProduct(product3);

        System.out.println("Products added:");
        stockList.displayStockList();
    }

    public void testRemoveProduct(StockList stockList) {
        Product product1 = new Product(1, "Product A", 10);
        Product product2 = new Product(2, "Product B", 20);

        stockList.addProduct(product1);
        stockList.addProduct(product2);

        System.out.println("Before removing:");
        stockList.displayStockList();

        stockList.removeProduct(1);

        System.out.println("After removing product with ID 1:");
        stockList.displayStockList();
    }

    public void testFindProduct(StockList stockList) {
        Product product1 = new Product(1, "Product A", 10);
        Product product2 = new Product(2, "Product B", 20);

        stockList.addProduct(product1);
        stockList.addProduct(product2);

        System.out.println("Searching for product with ID 2:");
        Product foundProduct = stockList.findProductById(2);
        if (foundProduct != null) {
            foundProduct.printProductDetails();
        } else {
            System.out.println("Product not found.");
        }
    }

    public void testPrintProducts(StockList stockList) {
        Product product1 = new Product(1, "Product A", 10);
        Product product2 = new Product(2, "Product B", 20);

        stockList.addProduct(product1);
        stockList.addProduct(product2);

        System.out.println("Printing all products:");
        stockList.displayStockList();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockList stockList = new StockList();
        StockDemo stockDemo = new StockDemo();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Find a product");
            System.out.println("4. Print all products");
            System.out.println("5. Run tests");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product newProduct = new Product(id, name, quantity);
                    stockList.addProduct(newProduct);
                    System.out.println("Product added.");
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    stockList.removeProduct(removeId);
                    break;

                case 3:
                    System.out.print("Enter product ID to find: ");
                    int findId = scanner.nextInt();
                    Product foundProduct = stockList.findProductById(findId);
                    if (foundProduct != null) {
                        foundProduct.printProductDetails();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    stockList.displayStockList();
                    break;

                case 5:
                    stockDemo.run(stockList);
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
