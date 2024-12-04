package com.ghostappi.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class ShoppingCartProductPK implements Serializable{

    private ShoppingCart shoppingCart;
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartProductPK shoppingCartProductPK)) return false;
        return product.getIdProduct() == shoppingCartProductPK.product.getIdProduct() && Objects.equals(shoppingCart, shoppingCartProductPK.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, shoppingCart);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Product getProduct() {
        return product;
    }
}
