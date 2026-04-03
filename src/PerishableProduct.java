/*
Durham College - Computer Programming and Analysis
COSC 1200 Object-Oriented Programming 1 [Ken Hodgson]
Daniel Doro Leao | SID: 101042176
Date: 2026-04-02
Activity Name: Assignment 3 - Inheritance - Product List
*/

import java.time.LocalDate;

public class PerishableProduct extends Product {

    private LocalDate expiryDate;

    // Default Constructor
    public PerishableProduct() {
        super();
        expiryDate = LocalDate.now();
    }

    // Overloaded Constructor
    public PerishableProduct(String sku, String productName, double unitCost, double salePrice,
                             int quantityOnHand, int quantityNeeded,
                             String specialInstructions, LocalDate expiryDate) {

        super(sku, productName, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Override display
    @Override
    public String toString() {
        return super.toString() +
                "\nExpiry Date: " + expiryDate;
    }
}