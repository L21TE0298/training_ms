package com.ghostappi.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shoppingcartproduct")
@IdClass(ShoppingCartProductPK.class)


public class ShoppingCartProduct {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idShoppingCart")
    @JsonBackReference
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    private Product product;

    @Column(name = "quantity")
    @Positive(message = "Quantity number must be a positive number")
    @Min(value = 1, message = "The quantity number min value is 1")
    @NotNull(message = "The quantity number must contain at least one digit")
    private Short quantity;
    

}
