package org.example.market.controller;

import lombok.RequiredArgsConstructor;
import org.example.market.dto.response.ProductResponse;
import org.example.market.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{eventId}/product")
    public ResponseEntity<ProductResponse> getProductsByEvent(@PathVariable Long eventId) {
        ProductResponse response = productService.getProductsByEvent(eventId);
        return ResponseEntity.ok(response);
    }
}
