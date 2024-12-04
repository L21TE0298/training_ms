package com.ghostappi.backend.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @Column(name = "idShoppingCart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idShoppingCart")
    private Integer idShoppingCart;

    @Column(name = "totalAmount")
    @JsonProperty("totalAmount")
    @NotNull(message = "The total amount cannot be null.")
    // @Min(value = 0, message = "The total amount must be at least 0.")
    private BigDecimal totalAmount;

    @Column(name = "totalProducts")
    @JsonProperty("totalProducts")
    @Min(value = 1, message = "The total products must be at least 1.")
    private Short totalProducts;

    @Column(name = "idUser")
    @JsonProperty("idUser")
    private Integer idUser;


}
