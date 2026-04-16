package com.sys.dao;

import com.sys.model.Supplier;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In-memory implementation of SupplierDAO for demonstration purposes.
 */
public class MockSupplierDAOImpl implements SupplierDAO {
    private final List<Supplier> suppliers = new ArrayList<>();
    private int nextId = 1;

    public MockSupplierDAOImpl() {
        // Add default data
        addSupplier(new Supplier(0, "Murali", "9988776655", "murali@gmail.com", "9988776655", "coimbatore", null, false));
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        supplier.setSupplierId(nextId++);
        supplier.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return suppliers.add(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return suppliers.stream()
                .filter(s -> !s.isDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public Supplier getSupplierById(int id) {
        return suppliers.stream()
                .filter(s -> s.getSupplierId() == id && !s.isDeleted())
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Supplier> searchSuppliers(String query) {
        String lowerQuery = query.toLowerCase();
        return suppliers.stream()
                .filter(s -> !s.isDeleted())
                .filter(s -> String.valueOf(s.getSupplierId()).equals(query) || 
                             s.getName().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        for (int i = 0; i < suppliers.size(); i++) {
            if (suppliers.get(i).getSupplierId() == supplier.getSupplierId()) {
                suppliers.set(i, supplier);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        Supplier s = getSupplierById(id);
        if (s != null) {
            s.setDeleted(true);
            return true;
        }
        return false;
    }
}
