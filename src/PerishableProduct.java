/*
Durham College - Computer Programming and Analysis
COSC 1200 Object-Oriented Programming 1 [Ken Hodgson]
Daniel Doro Leao | SID: 101042176
Date: 2026-04-02
Activity Name: Assignment 3 - Inheritance - Product List
*/

import java.time.LocalDate;

// PerishableProduct class - Inherits from Product - expiry date
public class PerishableProduct extends Product {

    // Additional data member
    private LocalDate expiryDate;

    // Default constructor - Calls the Product constructor and assigns a default expiry date
    public PerishableProduct() {
        super();
        expiryDate = LocalDate.now();
    }

    // Overloaded constructor - Initializes both the inherited properties
    public PerishableProduct(String sku, String productName, double unitCost, double salePrice,
                             int quantityOnHand, int quantityNeeded,
                             String specialInstructions, LocalDate expiryDate) {

        // Call constructor of parent class
        super(sku, productName, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);

        // Set expiry date
        this.expiryDate = expiryDate;
    }

    // Getter for expiry date
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setter for expiry date
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Override toString method to also display expiry date
    @Override
    public String toString() {

        // Use parent toString then add expiry date
        return super.toString() +
                "\nExpiry Date: " + expiryDate;
    }
}