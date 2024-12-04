package com.ghostappi.backend.dto;

import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ShoppingCartDTO {

    // @Id
    // @Column(name = "idShoppingCart")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonProperty("idShoppingCart")
    // @JsonIgnore
    // private Integer idShoppingCart;

    @Column(name = "totalAmount")
    @JsonProperty("totalAmount")
    @NotNull(message = "The total amount cannot be null.")
    @Min(value = 0, message = "The total amount must be at least 0.")
    private BigDecimal totalAmount;

    @Column(name = "totalProducts")
    @JsonProperty("totalProducts")
    @Min(value = 1, message = "The total products must be at least 1.")
    private Short totalProducts;

    @Column(name = "idUser", nullable = false)
    @JsonProperty("idUser")
    @Positive(message = "The user ID must be positive.")
    private Integer idUser;

    @NotNull(message = "The products list cannot be null.")
    private List<ShoppingCartProductDTO> products;
}
