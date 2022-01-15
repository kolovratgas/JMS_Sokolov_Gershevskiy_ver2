package com.example.practice4.util;

import com.example.practice4.dto.ProductDTO;
import com.example.practice4.dto.SupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "result")
@XmlSeeAlso({
        SupplierDTO.class,
        ProductDTO.class
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultDTO<T> {

    @XmlElementWrapper(name = "body")
    @XmlElement(name = "entry")
    private Collection<T> body;

    @XmlElement
    private HttpStatus status;

    private ResultDTO(Collection<T> body) {
        this.body = body;
        this.status = HttpStatus.OK;
    }

    private ResultDTO(HttpStatus status) {
        this.body = null;
        this.status = status;
    }

    public static <T> ResultDTO<T> of(Collection<T> result) {
        return new ResultDTO<>(result);
    }

    public static <T> ResultDTO<T> of(HttpStatus status) {
        return new ResultDTO<>(status);
    }
}
