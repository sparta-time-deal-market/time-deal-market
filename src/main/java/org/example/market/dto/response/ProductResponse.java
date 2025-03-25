package org.example.market.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long eventId;
    private String eventTitle;
    private ProductInfo product;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductInfo {
        private Long productId;
        private String name;
        private String description;
        private int price;
        private int stock;
        private boolean isSoldOut;
    }
}
