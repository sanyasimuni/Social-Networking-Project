package com.prodict.DTO;

import java.time.LocalDateTime;

import com.prodict.Entity.Status;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	
	private Integer orderId;
	
	//private Long productId;
    @NotBlank(message = "Customer name cannot be blank")
    @Size(max = 100, message = "Customer name must not exceed 100 characters")
    private String customerName;
    @NotBlank(message = "Product name cannot be blank")
    @Size(max = 200, message = "Product name must not exceed 200 characters")
    private String product;
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double price;
    
    private Status status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELED
    private LocalDateTime orderDate;
    private LocalDateTime updatedDate;
    private String trackingId; // 
   
    

    

}
