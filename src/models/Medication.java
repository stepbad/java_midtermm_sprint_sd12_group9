package src.models;

import java.time.LocalDate;

/**
 * The Medication class represents a drug in the pharmacy system.
 * It includes attributes for identification, dosage, stock quantity, and expiration date.
 * 
 * @author Stephen
 * @version 1.0
 */
public class Medication {
    private String id;
    private String name;
    private int quantity;
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication object.
     * 
     * @param id         The unique identifier for the medication.
     * @param name       The name of the medication.
     * @param quantity   The stock quantity of the medication.
     * @param expiryDate The expiration date of the medication.
     */
    public Medication(String id, String name, int quantity, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the name of the medication.
     * 
     * @return The name of the medication.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the medication.
     * 
     * @return The medication ID.
     */
    public String getId() {
        return id;
    }


     /**
     * Sets the name of the medication.
     * 
     * @param name The new name for the medication.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the quantity of the medication in stock.
     * 
     * @param quantity The new stock quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Returns a string representation of the medication.
     * 
     * @return A formatted string containing medication details.
     */
    @Override
    public String toString() {
        return "Medication{" +
            "ID='" + id + '\'' +
            ", Name='" + name + '\'' +
            ", Quantity=" + quantity +
            ", Expiry Date=" + expiryDate +
            '}';
    }
}


    // Getters & Setters (To be implemented)
