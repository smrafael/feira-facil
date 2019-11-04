package com.unipe.feirafacil.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq")
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "discount_id")
    private Discount discount;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @NotNull
    private LocalDateTime orderedAt;
    
}
