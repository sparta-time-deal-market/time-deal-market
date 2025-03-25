package org.example.market.service;

import lombok.RequiredArgsConstructor;
import org.example.market.dto.response.ProductResponse;
import org.example.market.entity.Product;
import org.example.market.entity.Event;
import org.example.market.repository.EventRepository;
import org.example.market.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductResponse getProductByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("해당 이벤트가 존재하지 않습니다."));

        Product product = productRepository.findByEventId(eventId)
                .orElseThrow(() -> new IllegalArgumentException("해당 이벤트에 연결된 상품이 없습니다."));

        ProductResponse.ProductInfo productInfo = ProductResponse.ProductInfo.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .isSoldOut(product.getStock() <= 0)
                .build();

        return ProductResponse.builder()
                .eventId(event.getId())
                .eventTitle(event.getTitle())
                .product(productInfo)
                .build();
    }
}