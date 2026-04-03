/*
Durham College - Computer Programming and Analysis
COSC 1200 Object-Oriented Programming 1 [Ken Hodgson]
Daniel Doro Leao | SID: 101042176
Date: 2026-04-02
Activity Name: Assignment 3 - Inheritance - Product List
*/


// Generic product in the store (normal / not perishable)
public class Product {

    // Describing a product (properties)
    private String sku;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Default constructor (default values)
    public Product() {
        sku = "00000000";
        productName = "Unknown Product";
        unitCost = 0.0;
        salePrice = 0.0;
        quantityOnHand = 0;
        quantityNeeded = 0;
        specialInstructions = "None";
    }

    // Parameterized constructor
    // Allows the creation of a product with user-provided values
    public Product(String sku, String productName, double unitCost, double salePrice,
                   int quantityOnHand, int quantityNeeded, String specialInstructions) {

        this.sku = sku;
        this.productName = productName;
        this.unitCost = unitCost;
        this.salePrice = salePrice;
        this.quantityOnHand = quantityOnHand;
        this.quantityNeeded = quantityNeeded;
        this.specialInstructions = specialInstructions;
    }

    // Getter and Setter for SKU
    public final String getSku() {
        return sku;
    }

    public final void setSku(String sku) {
        this.sku = sku;
    }

    // Getter and Setter for product name
    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for unit cost
    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    // Getter and Setter for sale price
    public final double getSalePrice() {
        return salePrice;
    }

    public final void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    // Getter and Setter for quantity available in store
    public final int getQuantityOnHand() {
        return quantityOnHand;
    }

    public final void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    // Getter and Setter for quantity required for next order
    public final int getQuantityNeeded() {
        return quantityNeeded;
    }

    public final void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public final void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // toString method - Product information
    @Override
    public String toString() {

        return "\nSKU: " + sku +
                "\nProduct Name: " + productName +
                "\nUnit Cost: $" + unitCost +
                "\nSale Price: $" + salePrice +
                "\nQuantity on hand: " + quantityOnHand +
                "\nQuantity Needed: " + quantityNeeded +
                "\nSpecial Instructions: " + specialInstructions;
    }
}