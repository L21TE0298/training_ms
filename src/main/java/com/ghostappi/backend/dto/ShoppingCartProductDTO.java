package com.ghostappi.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ShoppingCartProductDTO {

    // @Positive(message = "The shopping cart id must be a positive number")
    // @Min(value = 1, message = "The shopping cart id min value is 1")
    // @NotNull(message = "The shopping cart id must contain at least one digit")
    // private Integer idShoppingCart;

    @Positive(message = "The shopping cart id must be a positive number")
    @Min(value = 1, message = "The shopping cart id min value is 1")
    @NotNull(message = "The shopping cart id must contain at least one digit")
    private Integer idProduct;

    @Positive(message = "Quantity number must be a positive number")
    @Min(value = 1, message = "The quantity number min value is 1")
    @NotNull(message = "The quantity number must contain at least one digit")
    private Short quantity;
}
