// package com.ghostappi.backend.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.media.ArraySchema;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import jakarta.validation.Valid;

// import com.ghostappi.backend.service.ShoppingCartService;
// import com.ghostappi.backend.dto.ShoppingCartDTO;
// import com.ghostappi.backend.model.ShoppingCart;

// @RestController
// @Validated
// @RequestMapping("/shoppingcarts")
// @CrossOrigin(origins = "*", methods = {
//                 RequestMethod.GET,
//                 RequestMethod.POST,
//                 RequestMethod.DELETE,
//                 RequestMethod.PUT
// })
// @Tag(name = "ShoppingCarts", description = "Provides methods for managing shopping carts")
// public class ShoppingCartController {

//         @Autowired
//         private ShoppingCartService shoppingCartService;

//         @Operation(summary = "Get all shopping carts with pagination", description = "Return a list of shopping carts with pagination")
//         @ApiResponse(responseCode = "200", description = "Success", content = {
//                         @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ShoppingCart.class)))
//         })

//         @GetMapping(params = { "page", "size" })
//         public List<ShoppingCart> getAll(
//                         @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//                         @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
//                 List<ShoppingCart> shoppingCarts = shoppingCartService.getAll(page, size);
//                 return shoppingCarts;
//         }

//         @Operation(summary = "Save a shopping cart", description = "Save a shopping cart")
//         @ApiResponse(responseCode = "200", description = "Shopping cart saved succesfully", content = {
//                         @Content(mediaType = "application/json", schema = @Schema(implementation = ShoppingCart.class))
//         })

//         @PostMapping
//         public ResponseEntity<?> save(@Valid @RequestBody ShoppingCartDTO shoppingCartDTO) {
//                 shoppingCartService.save(shoppingCartDTO);
//                 return new ResponseEntity<>("Shopping cart saved succesfully", HttpStatus.CREATED);
//         }
// }
