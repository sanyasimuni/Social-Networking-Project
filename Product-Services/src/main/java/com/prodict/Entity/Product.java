package com.prodict.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="PRODUCT_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@JsonProperty("suplierId")
    private Integer suplierId;
	@JsonProperty("ordreId")
    private Integer ordreId;
    
	private String productName;
	private String description;
	private Integer quantity;
	private String price;
	@CreatedDate
	private LocalDateTime date;
	private Status status;
	
	
	
}
