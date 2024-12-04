package com.ghostappi.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import com.ghostappi.backend.service.ShoppingCartProductService;
import com.ghostappi.backend.model.ShoppingCartProduct;

@RestController
@RequestMapping("shoppingCartProducts")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE })
@Tag(name = "Shopping Cart Products", description = "Provides methods for managing products in the shopping cart")
public class ShoppingCartProductController {

    @Autowired
    private ShoppingCartProductService service;

    @Operation(summary = "List all shopping cart products")
    @ApiResponse(responseCode = "200", description = "Found all shopping cart products", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ShoppingCartProduct.class))) })
    @GetMapping(params = { "page", "size" })
    public List<ShoppingCartProduct> getAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        List<ShoppingCartProduct> shoppingCartProducts = service.getAll(page, size);
        return shoppingCartProducts;
    }

}
