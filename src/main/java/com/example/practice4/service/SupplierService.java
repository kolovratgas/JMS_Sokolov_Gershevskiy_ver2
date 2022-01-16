package com.example.practice4.service;

import com.example.practice4.dto.SupplierDTO;
import com.example.practice4.jms.SenderMessage;
import com.example.practice4.model.Supplier;

import java.util.List;
public interface SupplierService {

    List<SupplierDTO> getAll();

    SupplierDTO get(Long id);

    void delete(Long id);

    void send(SenderMessage senderMessage, String massage);

    void edit(Supplier newSupplier);

    SupplierDTO save(Supplier supplier);

}
