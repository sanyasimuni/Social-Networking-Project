package com.prodict.DTO;

import java.time.LocalDateTime;

import com.prodict.Entity.Status;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductResponse {
	
	
	private Integer productId;
	
	private Integer suplierId;
	
    private Integer ordreId;
    
	@NotEmpty(message = "Product Name Must Entire! ")
	private String productName;
	
	@NotNull(message = "Product Description  Add.")
	private String description;
	
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity must be greater than or equal to 1")
	private Integer quantity;

	@NotNull(message = "Product  Price Added !")
	private String price;
	
	private LocalDateTime date;
	private Status status;
	
	private OrderResponse orderResponse;
	private SupplierResponse supplierResponse;

}
