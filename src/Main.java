/*
Durham College - Computer Programming and Analysis
COSC 1200 Object-Oriented Programming 1 [Ken Hodgson]
Daniel Doro Leao | SID: 101042176
Date: 2026-04-02
Activity Name: Assignment 3 - Inheritance - Product List
*/

// Scanner object - user input
static Scanner scanner = new Scanner(System.in);

// ArrayList used to store all products
static ArrayList<Product> products = new ArrayList<>();

void main() {

    int choice;

    // Program runs until user chooses Exit
    do {
        // Display menu
        IO.println("\n==== PRODUCT MENU ====");
        IO.println("1) Create Product");
        IO.println("2) Create Perishable Product");
        IO.println("3) Edit Product by SKU");
        IO.println("4) Delete Product by SKU");
        IO.println("5) Display Product by SKU");
        IO.println("6) Display all Products");
        IO.println("7) Exit");

        // Ask user for menu choice
        IO.print("Select option: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        // Menu option
        switch (choice) {
            case 1 -> createProduct();
            case 2 -> createPerishableProduct();
            case 3 -> editProduct();
            case 4 -> deleteProduct();
            case 5 -> displayProduct();
            case 6 -> displayAllProducts();
            case 7 -> IO.println("Exiting program...");
            default -> IO.println("Invalid option.");
        }
    } while (choice != 7);
}

// Method to create a normal product
static void createProduct() {

    // Ask user for product information
    IO.print("Enter SKU: ");
    String sku = scanner.nextLine();

    IO.print("Product name: ");
    String name = scanner.nextLine();

    IO.print("Unit cost: ");
    double cost = scanner.nextDouble();

    IO.print("Sale price: ");
    double price = scanner.nextDouble();

    IO.print("Quantity on hand: ");
    int qty = scanner.nextInt();

    IO.print("Quantity needed: ");
    int needed = scanner.nextInt();
    scanner.nextLine();

    IO.print("Special instructions: ");
    String instructions = scanner.nextLine();

    // Create product - object
    Product product = new Product(sku, name, cost, price, qty, needed, instructions);

    // Add product to the list
    products.add(product);

    IO.println("Product added.");
}

// Method to create a perishable product
static void createPerishableProduct() {

    IO.print("Enter SKU: ");
    String sku = scanner.nextLine();

    IO.print("Product name: ");
    String name = scanner.nextLine();

    IO.print("Unit cost: ");
    double cost = scanner.nextDouble();

    IO.print("Sale price: ");
    double price = scanner.nextDouble();

    IO.print("Quantity on hand: ");
    int qty = scanner.nextInt();

    IO.print("Quantity needed: ");
    int needed = scanner.nextInt();
    scanner.nextLine();

    IO.print("Special instructions: ");
    String instructions = scanner.nextLine();

    // Ask user for expiry date
    IO.print("Expiry year: ");
    int year = scanner.nextInt();

    IO.print("Expiry month: ");
    int month = scanner.nextInt();

    IO.print("Expiry day: ");
    int day = scanner.nextInt();

    // Convert values into LocalDate
    LocalDate expiry = LocalDate.of(year, month, day);

    // Create perishable product
    PerishableProduct product = new PerishableProduct(
            sku, name, cost, price, qty, needed, instructions, expiry
    );

    // Add to list
    products.add(product);

    IO.println("Perishable product added.");
}

// Method to find a product by SKU
static Product findProduct(String sku) {

    // Loop through products
    for (Product p : products) {

        // Check if SKU matches
        if (p.getSku().equals(sku)) {
            return p;
        }
    }

    // If product not found
    return null;
}

// Method to edit a product
static void editProduct() {

    IO.print("Enter SKU to edit: ");
    String sku = scanner.nextLine();

    // Find product in list
    Product p = findProduct(sku);

    // If product does not exist
    if (p == null) {
        IO.println("Product not found.");
        return;
    }

    // Update product information
    IO.print("New name: ");
    p.setProductName(scanner.nextLine());

    IO.print("New unit cost: ");
    p.setUnitCost(scanner.nextDouble());

    IO.print("New sale price: ");
    p.setSalePrice(scanner.nextDouble());

    IO.print("New quantity on hand: ");
    p.setQuantityOnHand(scanner.nextInt());

    IO.print("New quantity needed: ");
    p.setQuantityNeeded(scanner.nextInt());
    scanner.nextLine();

    IO.print("New instructions: ");
    p.setSpecialInstructions(scanner.nextLine());

    IO.println("Product updated.");
}

// Method to delete a product
static void deleteProduct() {

    IO.print("Enter SKU to delete: ");
    String sku = scanner.nextLine();

    Product p = findProduct(sku);

    if (p != null) {
        products.remove(p);
        IO.println("Product deleted.");
    } else {
        IO.println("Product not found.");
    }
}

// Method to display a single product
static void displayProduct() {

    IO.print("Enter SKU: ");
    String sku = scanner.nextLine();

    Product p = findProduct(sku);

    if (p != null) {
        IO.println(p);
    } else {
        IO.println("Product not found.");
    }
}

// Method to display all products in the list
static void displayAllProducts() {

    if (products.isEmpty()) {
        IO.println("No products available.");
        return;
    }

    // Loop through list and print each product
    for (Product p : products) {
        IO.println(p);
        IO.println("---------------------");
    }
}