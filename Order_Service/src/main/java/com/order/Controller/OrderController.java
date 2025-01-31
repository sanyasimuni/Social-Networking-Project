package com.order.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.DTO.OrderResponse;
import com.order.Services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/add")
	public ResponseEntity<OrderResponse>addOrder(@Valid  @RequestBody OrderResponse orderResponse){
		          OrderResponse response=this.orderService.addOrder(orderResponse);
		return new ResponseEntity<OrderResponse>(response,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/update/{orderId}")
	public ResponseEntity<OrderResponse>UpdateOrder(@RequestBody OrderResponse orderResponse,
			@PathVariable Integer orderId){
		OrderResponse response=this.orderService.updateOrder(orderResponse, orderId);
		return new ResponseEntity<OrderResponse>(response,HttpStatus.OK);

	}
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse>SingleOrder(@PathVariable Integer orderId){
		OrderResponse response=this.orderService.singleOrder(orderId);
		return new ResponseEntity<OrderResponse>(response,HttpStatus.OK);

	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<OrderResponse>>ListOrder(){
		List<OrderResponse> response=this.orderService.listOfOrder();
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?>DeleteOrder(@PathVariable Integer orderId){
		 this.orderService.DeleteOrder(orderId);
		return new ResponseEntity<>("ID DELETE !",HttpStatus.OK);

	}
	

}
