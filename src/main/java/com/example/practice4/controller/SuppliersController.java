package com.example.practice4.controller;

import com.example.practice4.dto.SupplierDTO;
import com.example.practice4.model.Supplier;
import com.example.practice4.service.SupplierService;
import com.example.practice4.util.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResultDTO<SupplierDTO> getAllSuppliers() {
        return ResultDTO.of(supplierService.getAll());
    }

    @GetMapping(value = "/{supplierId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResultDTO<SupplierDTO> getSupplier(@PathVariable Long supplierId) {
        return ResultDTO.of(
                Collections.singletonList(supplierService.get(supplierId))
        );
    }

    @DeleteMapping(value = "/{supplierId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResultDTO deleteSupplier(@PathVariable Long supplierId) {
        supplierService.delete(supplierId);

        return ResultDTO.of(HttpStatus.OK);
    }

    @PutMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResultDTO<SupplierDTO> editSupplier(Supplier supplier) {
        supplierService.edit(supplier);

        return ResultDTO.of(HttpStatus.OK);
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResultDTO createSupplier(Supplier supplier) {

        return ResultDTO.of(
                Collections.singletonList(supplierService.save(supplier))
        );
    }
}
