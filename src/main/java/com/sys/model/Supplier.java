package com.sys.model;

import java.sql.Timestamp;

/**
 * Model class representing a Supplier entity.
 */
public class Supplier {
    private int supplierId;
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;
    private Timestamp createdAt;
    private boolean isDeleted;

    // Default Constructor
    public Supplier() {}

    // Constructor with parameters
    public Supplier(int supplierId, String name, String contactPerson, String email, String phone, String address, Timestamp createdAt, boolean isDeleted) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    @Override
    public String toString() {
        return "Supplier ID: " + supplierId + "\n" +
               "Name: " + name + "\n" +
               "Contact: " + contactPerson + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phone + "\n" +
               "Address: " + address + "\n" +
               "Created At: " + createdAt + "\n" +
               "---------------------------------";
    }
}
