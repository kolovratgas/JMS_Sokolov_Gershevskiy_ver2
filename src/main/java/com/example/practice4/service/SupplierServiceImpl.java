package com.example.practice4.service;

import com.example.practice4.Practice4Application;
import com.example.practice4.dto.SupplierDTO;
import com.example.practice4.jms.SenderMessage;
import com.example.practice4.model.Supplier;
import com.example.practice4.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDTO> getAll() {
        return supplierRepository.findAll().stream()
                .map(SupplierDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO get(Long id) {
        return new SupplierDTO(supplierRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public void send(SenderMessage senderMessage, String massage) {
        JmsTemplate jmsTemplate = Practice4Application.context.getBean(JmsTemplate.class);
        System.out.println("Sending a JMS message.");
        jmsTemplate.convertAndSend("sampleQueue",  massage);}

    @Override
    public void edit(Supplier newSupplier) {
        Supplier oldSupplier =
                supplierRepository.findById(newSupplier.getId()).orElseThrow(() ->
                        new EmptyResultDataAccessException(String.format("No entity with id %s exists!", newSupplier), 1)
                );

        oldSupplier.setName(newSupplier.getName());
        oldSupplier.setAddress(newSupplier.getAddress());
        oldSupplier.setINN(newSupplier.getINN());
        oldSupplier.setPhone(newSupplier.getPhone());
        oldSupplier.setProducts(newSupplier.getProducts());

        supplierRepository.save(oldSupplier);
    }

    @Override
    public SupplierDTO save(Supplier supplier) {
        return new SupplierDTO(supplierRepository.save(supplier));
    }
}
