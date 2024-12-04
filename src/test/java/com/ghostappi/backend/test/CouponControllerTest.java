package com.ghostappi.backend.test;


import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class CouponControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertThat(mvc).isNotNull();
    }

    @Test
    public void getAllActiveCouponsTest() throws Exception {
        mvc.perform(get("/coupons/active").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    public void getAllInactiveCouponsTest() throws Exception {
        mvc.perform(get("/coupons/inactive").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(greaterThan(0))));
    }
    @Test
    public void createCouponTest() throws Exception {
        String newCouponJson = """
         {
  "codeDiscount": "string",
  "description": "string",
  "initDate": "2024-11-24T18:17:22.160Z",
  "expirationDate": "2024-11-25T18:17:22.160Z",
  "discountPercentage": 100,
  "status": true,
  "idCategory": 1
}
            """;
    
        String expectedResponseJson = """
         {
  "coupon": {
    "codeDiscount": "string",
    "description": "string",
    "initDate": "2024-11-24T18:17:22.160+00:00",
    "expirationDate": "2024-11-25T18:17:22.160+00:00",
    "discountPercentage": 100,
    "status": true,
    "idCategory": 1
  },
  "message": "Coupon registered successfully"
}
            """;
    
        mvc.perform(post("/coupons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCouponJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJson));
    }
    

    
    
    @Test
    public void updateCouponTest() throws Exception {
        // JSON válido para PUT
        String updatedCouponJson = """
             {
    "expired": false,
    "idCoupon": 13,
    "codeDiscount": "string",
    "description": "string",
    "initDate": "2024-11-24T06:00:00.000+00:00",
    "expirationDate": "2024-11-28T06:00:00.000+00:00",
    "discountPercentage": 90,
    "status": true,
    "idCategory": {
      "idCategory": 1
    }
  }
            """;
    
        mvc.perform(put("/coupons/13") // El ID debe ser válido
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedCouponJson))
                .andDo(print())
                .andExpect(status().isOk()) // El controlador debe devolver 200 si la actualización es exitosa
                .andExpect(content().string("Updated record"));
    }
    
    @Test
    public void getCouponByIdNotFoundTest() throws Exception {
        mvc.perform(get("/coupons/9999").accept(MediaType.APPLICATION_JSON)) // Non-existent coupon ID
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("The requested item is not registered"));
    }
}
