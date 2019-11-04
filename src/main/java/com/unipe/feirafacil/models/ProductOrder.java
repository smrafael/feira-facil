package com.unipe.feirafacil.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "products_order")
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_order_seq")
    @SequenceGenerator(name = "products_order_seq", sequenceName = "products_order_seq")
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

}
