package com.ghostappi.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ghostappi.backend.model.ShoppingCartProduct;
import com.ghostappi.backend.model.ShoppingCartProductPK;

@Repository
public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, ShoppingCartProductPK> {

}
