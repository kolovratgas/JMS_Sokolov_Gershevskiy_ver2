package com.example.practice4.dto;

import com.example.practice4.model.Supplier;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplier")
@NoArgsConstructor
public class SupplierDTO {

    @XmlTransient
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private String INN;

    @XmlElement
    private String address;

    @XmlElement
    private String phone;

    @XmlElementWrapper(name = "supplied-products")
    @XmlElement(name = "product")
    private List<ProductDTO> products;

    public SupplierDTO(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.INN = supplier.getINN();
        this.address = supplier.getAddress();
        this.phone = supplier.getPhone();
        if (supplier.getProducts() != null) {
            this.products =
                    supplier.getProducts().stream()
                            .map(ProductDTO::new)
                            .collect(Collectors.toList());
        }
    }
}
