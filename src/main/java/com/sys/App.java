package com.sys;

import com.sys.model.Supplier;
import com.sys.service.SupplierService;

import java.util.List;
import java.util.Scanner;

/**
 * Main Application class with menu-driven interface.
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static SupplierService service;

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   Supplier Management System (JDBC)     ");
        System.out.println("==========================================");

        // Detect Database Connection
        if (com.sys.util.DBConnection.getConnection() != null) {
            System.out.println("[INFO] Connected to MySQL Database.");
            service = new SupplierService(); 
        } else {
            System.out.println("[WARNING] Database not found/reachable.");
            System.out.println("[INFO] Starting in SIMULATION MODE (In-Memory).");
            System.out.println("[NOTE] Data will not persist after closing.");
            service = new SupplierService(new com.sys.dao.MockSupplierDAOImpl());
        }

        boolean exit = false;

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addSupplier(); break;
                case "2": viewAllSuppliers(); break;
                case "3": searchSupplier(); break;
                case "4": updateSupplier(); break;
                case "5": deleteSupplier(); break;
                case "6": exit = true; System.out.println("Exiting Application. Goodbye!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Add New Supplier");
        System.out.println("2. View All Suppliers");
        System.out.println("3. Search Supplier (ID or Name)");
        System.out.println("4. Update Supplier");
        System.out.println("5. Delete Supplier");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addSupplier() {
        System.out.println("\n--- Add New Supplier ---");
        Supplier s = new Supplier();
        
        System.out.print("Enter Name: ");
        s.setName(scanner.nextLine());
        
        System.out.print("Enter Contact Person: ");
        s.setContactPerson(scanner.nextLine());
        
        System.out.print("Enter Email: ");
        s.setEmail(scanner.nextLine());
        
        System.out.print("Enter Phone: ");
        s.setPhone(scanner.nextLine());
        
        System.out.print("Enter Address: ");
        s.setAddress(scanner.nextLine());

        String result = service.addSupplier(s);
        System.out.println(result);
    }

    private static void viewAllSuppliers() {
        System.out.println("\n--- All Suppliers ---");
        List<Supplier> suppliers = service.getAllSuppliers();
        if (suppliers.isEmpty()) {
            System.out.println("No suppliers found.");
        } else {
            suppliers.forEach(System.out::println);
        }
    }

    private static void searchSupplier() {
        System.out.print("\nEnter ID or Name to search: ");
        String query = scanner.nextLine();
        List<Supplier> results = service.searchSuppliers(query);
        
        if (results.isEmpty()) {
            System.out.println("No matching suppliers found.");
        } else {
            System.out.println("\n--- Search Results ---");
            results.forEach(System.out::println);
        }
    }

    private static void updateSupplier() {
        System.out.print("\nEnter Supplier ID to update: ");
        String idStr = scanner.nextLine();
        try {
            int id = Integer.parseInt(idStr);
            Supplier existing = service.getSupplierById(id);
            if (existing == null) {
                System.out.println("Supplier not found!");
                return;
            }

            System.out.println("Current details: \n" + existing);
            System.out.println("Enter new details (press Enter to keep current):");

            System.out.print("New Name [" + existing.getName() + "]: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) existing.setName(name);

            System.out.print("New Contact Person [" + existing.getContactPerson() + "]: ");
            String contact = scanner.nextLine();
            if (!contact.isEmpty()) existing.setContactPerson(contact);

            System.out.print("New Email [" + existing.getEmail() + "]: ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) existing.setEmail(email);

            System.out.print("New Phone [" + existing.getPhone() + "]: ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) existing.setPhone(phone);

            System.out.print("New Address [" + existing.getAddress() + "]: ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) existing.setAddress(address);

            String result = service.updateSupplier(existing);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
        }
    }

    private static void deleteSupplier() {
        System.out.print("\nEnter Supplier ID to delete: ");
        String idStr = scanner.nextLine();
        try {
            int id = Integer.parseInt(idStr);
            String result = service.deleteSupplier(id);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
        }
    }
}
