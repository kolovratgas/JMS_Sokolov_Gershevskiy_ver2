package com.example.practice4.service;

import com.example.practice4.dto.SupplierDTO;
import com.example.practice4.model.Supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> getAll();

    SupplierDTO get(Long id);

    void delete(Long id);

    void edit(Supplier newSupplier);

    SupplierDTO save(Supplier supplier);
}
