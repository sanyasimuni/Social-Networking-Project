package com.suplier.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class SupplierResponse {
	
	private Integer sId;
	@NotBlank(message = "Name cannot be blank.")
	@Size(max = 50, message = "Name cannot exceed 50 characters.")
	private String name;
	 
	@NotBlank(message = "Address cannot be blank.")
	@Size(max = 255, message = "Address cannot exceed 255 characters.")
	private String address;
	
	@NotBlank(message = "Contact details cannot be blank.")
	@Pattern(regexp = "^[0-9]{10}$", message = "Contact details must be a valid 10-digit number.")
	private String contactDetails;
	
	private LocalDateTime created;
	private LocalDateTime updated;
	

}
