package com.sys.dao;

import com.sys.model.Supplier;
import java.util.List;

/**
 * Interface defining CRUD operations for Supplier.
 */
public interface SupplierDAO {
    boolean addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(int id);
    List<Supplier> searchSuppliers(String query); // Search by name or ID
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id); // Soft delete
}
