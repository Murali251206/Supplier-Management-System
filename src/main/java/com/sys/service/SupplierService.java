package com.sys.service;

import com.sys.dao.SupplierDAO;
import com.sys.dao.SupplierDAOImpl;
import com.sys.model.Supplier;
import com.sys.util.InputValidator;

import java.util.List;

/**
 * Service layer for business logic and validation.
 */
public class SupplierService {
    private final SupplierDAO dao;

    public SupplierService() {
        this.dao = new SupplierDAOImpl();
    }

    public SupplierService(SupplierDAO dao) {
        this.dao = dao;
    }


    public String addSupplier(Supplier supplier) {
        if (!InputValidator.isNotEmpty(supplier.getName())) return "Error: Name cannot be empty.";
        if (!InputValidator.isValidEmail(supplier.getEmail())) return "Error: Invalid email format.";
        if (!InputValidator.isValidPhone(supplier.getPhone())) return "Error: Invalid phone number format.";

        boolean success = dao.addSupplier(supplier);
        return success ? "Supplier added successfully!" : "Failed to add supplier.";
    }

    public List<Supplier> getAllSuppliers() {
        return dao.getAllSuppliers();
    }

    public Supplier getSupplierById(int id) {
        return dao.getSupplierById(id);
    }

    public List<Supplier> searchSuppliers(String query) {
        return dao.searchSuppliers(query);
    }

    public String updateSupplier(Supplier supplier) {
        if (!InputValidator.isNotEmpty(supplier.getName())) return "Error: Name cannot be empty.";
        if (!InputValidator.isValidEmail(supplier.getEmail())) return "Error: Invalid email format.";
        if (!InputValidator.isValidPhone(supplier.getPhone())) return "Error: Invalid phone number format.";

        boolean success = dao.updateSupplier(supplier);
        return success ? "Supplier updated successfully!" : "Failed to update supplier.";
    }

    public String deleteSupplier(int id) {
        boolean success = dao.deleteSupplier(id);
        return success ? "Supplier deleted successfully (soft delete)!" : "Failed to delete supplier.";
    }
}
