package com.ghostappi.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ghostappi.backend.dto.ShoppingCartDTO;
import com.ghostappi.backend.dto.ShoppingCartProductDTO;
import com.ghostappi.backend.model.ShoppingCart;
import com.ghostappi.backend.model.ShoppingCartProduct;
import com.ghostappi.backend.model.Product;
import com.ghostappi.backend.repository.ProductRepository;
import com.ghostappi.backend.repository.ShoppingCartProductRepository;
import com.ghostappi.backend.repository.ShoppingCartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartProductRepository shoppingCartProductsRepository;

    public List<ShoppingCart> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ShoppingCart> pageResult = repository.findAll(pageRequest);
        return pageResult.getContent();
    }

    public void save(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = convertToEntity(shoppingCartDTO);
        repository.save(shoppingCart);

        List<ShoppingCartProduct> shoppingCartProducts = shoppingCartDTO.getProducts().stream()
                .map(shoppingCartProductDTO -> convertToEntity(shoppingCartProductDTO, shoppingCart))
                .collect(Collectors.toList());

        shoppingCartProductsRepository.saveAll(shoppingCartProducts);

    }

    private ShoppingCart convertToEntity(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setIdUser(shoppingCartDTO.getIdUser());
        shoppingCart.setTotalAmount(shoppingCartDTO.getTotalAmount());
        shoppingCart.setTotalProducts(shoppingCartDTO.getTotalProducts());
        return shoppingCart;
    }

    private ShoppingCartProduct convertToEntity(ShoppingCartProductDTO shoppingCartProductDTO,
            ShoppingCart shoppingCart) {

        Product product = productRepository.findById(shoppingCartProductDTO.getIdProduct()).orElse(null);

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();

        shoppingCartProduct.setProduct(product);
        shoppingCartProduct.setShoppingCart(shoppingCart);
        shoppingCartProduct.setQuantity(shoppingCartProductDTO.getQuantity());

        return shoppingCartProduct;
    }
}
