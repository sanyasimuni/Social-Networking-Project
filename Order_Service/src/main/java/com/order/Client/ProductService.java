/*
 * package com.order.Client;
 * 
 * import org.springframework.cloud.openfeign.FeignClient; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable;
 * 
 * import com.order.DTO.ProductResponse;
 * 
 * @FeignClient(name="PRODUCT-SERVICE",url =
 * "http://localhost:9090/api/product/") public interface ProductService {
 * 
 * @GetMapping("/{productId}") public
 * ResponseEntity<ProductResponse>findProductByOrder(@PathVariable Long
 * productId);
 * 
 * }
 */