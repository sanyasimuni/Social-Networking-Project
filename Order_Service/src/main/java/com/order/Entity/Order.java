package com.order.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.order.DTO.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer orderId;
	    //private Long productId;
	    private String customerName;
	    private String product;
	    private int quantity;
	    private double price;
	    private Status status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELED
	   @CreatedDate
	    private LocalDateTime orderDate;
	   @LastModifiedDate
	    private LocalDateTime updatedDate;
	    private String trackingId;

}
