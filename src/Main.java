/*
Durham College - Computer Programming and Analysis
COSC 1200 Object-Oriented Programming 1 [Ken Hodgson]
Daniel Doro Leao | SID: 101042176
Date: 2026-04-02
Activity Name: Assignment 3 - Inheritance - Product List
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== PRODUCT MENU ====");
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Edit Product by SKU");
            System.out.println("4) Delete Product by SKU");
            System.out.println("5) Display Product by SKU");
            System.out.println("6) Display all Products");
            System.out.println("7) Exit");
            System.out.print("Select option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> createProduct();
                case 2 -> createPerishableProduct();
                case 3 -> editProduct();
                case 4 -> deleteProduct();
                case 5 -> displayProduct();
                case 6 -> displayAllProducts();
                case 7 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option.");

            }

        } while (choice != 7);
    }

    static void createProduct() {

        System.out.print("Enter SKU (8+ digits): ");
        String sku = scanner.nextLine();

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Unit cost: ");
        double cost = scanner.nextDouble();

        System.out.print("Sale price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity on hand: ");
        int qty = scanner.nextInt();

        System.out.print("Quantity needed: ");
        int needed = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Special instructions: ");
        String instructions = scanner.nextLine();

        Product product = new Product(sku, name, cost, price, qty, needed, instructions);
        products.add(product);

        System.out.println("Product added.");
    }

    static void createPerishableProduct() {

        System.out.print("Enter SKU: ");
        String sku = scanner.nextLine();

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Unit cost: ");
        double cost = scanner.nextDouble();

        System.out.print("Sale price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity on hand: ");
        int qty = scanner.nextInt();

        System.out.print("Quantity needed: ");
        int needed = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Special instructions: ");
        String instructions = scanner.nextLine();

        System.out.print("Expiry year: ");
        int year = scanner.nextInt();

        System.out.print("Expiry month: ");
        int month = scanner.nextInt();

        System.out.print("Expiry day: ");
        int day = scanner.nextInt();

        LocalDate expiry = LocalDate.of(year, month, day);

        PerishableProduct product = new PerishableProduct(
                sku, name, cost, price, qty, needed, instructions, expiry
        );

        products.add(product);

        System.out.println("Perishable product added.");
    }

    static Product findProduct(String sku) {

        for (Product p : products) {
            if (p.getSku().equals(sku)) {
                return p;
            }
        }

        return null;
    }

    static void editProduct() {

        System.out.print("Enter SKU to edit: ");
        String sku = scanner.nextLine();

        Product p = findProduct(sku);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("New name: ");
        p.setProductName(scanner.nextLine());

        System.out.print("New unit cost: ");
        p.setUnitCost(scanner.nextDouble());

        System.out.print("New sale price: ");
        p.setSalePrice(scanner.nextDouble());

        System.out.print("New quantity on hand: ");
        p.setQuantityOnHand(scanner.nextInt());

        System.out.print("New quantity needed: ");
        p.setQuantityNeeded(scanner.nextInt());
        scanner.nextLine();

        System.out.print("New instructions: ");
        p.setSpecialInstructions(scanner.nextLine());

        System.out.println("Product updated.");
    }

    static void deleteProduct() {

        System.out.print("Enter SKU to delete: ");
        String sku = scanner.nextLine();

        Product p = findProduct(sku);

        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void displayProduct() {

        System.out.print("Enter SKU: ");
        String sku = scanner.nextLine();

        Product p = findProduct(sku);

        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Product not found.");
        }
    }

    static void displayAllProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
            System.out.println("---------------------");
        }
    }
}