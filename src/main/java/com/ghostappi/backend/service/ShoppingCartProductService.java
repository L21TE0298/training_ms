package com.ghostappi.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ghostappi.backend.model.ShoppingCartProduct;
import com.ghostappi.backend.repository.ShoppingCartProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartProductService {

    @Autowired
    private ShoppingCartProductRepository repository;

    public List<ShoppingCartProduct> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ShoppingCartProduct> pageResult = repository.findAll(pageRequest);
        return pageResult.getContent();
    }
}
