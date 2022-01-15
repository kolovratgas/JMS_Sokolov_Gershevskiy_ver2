package com.example.practice4.dto;

import com.example.practice4.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
public class ProductDTO {

    @XmlTransient
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private Integer code;

    @XmlElement
    private Double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
    }
}
