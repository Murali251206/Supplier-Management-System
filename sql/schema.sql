-- Supplier Management System Database Schema (MySQL)
-- Create Database
CREATE DATABASE IF NOT EXISTS supplier_management;
USE supplier_management;

-- Create Suppliers Table
CREATE TABLE IF NOT EXISTS suppliers (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    contact_person VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE -- Bonus: Soft Delete flag
);

-- Index for search optimization
CREATE INDEX idx_supplier_name ON suppliers(name);
