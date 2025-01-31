package com.order.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.DTO.OrderResponse;
import com.order.DTO.Status;
import com.order.Entity.Order;
import com.order.Exception.ResourceNotFoundException;
import com.order.OrderRepository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private  OrderRepo orderRepo;
	@Autowired
	private ModelMapper  mapper;
	
	
	
	@Override
	public OrderResponse addOrder(OrderResponse orderResponse) {
		 
	 Order order= this.mapper.map(orderResponse, Order.class);
	  order.setStatus(Status.PENDING);
	  order.setOrderDate(LocalDateTime.now());
	  order.setUpdatedDate(LocalDateTime.now());
	  order.setTrackingId(UUID.randomUUID().toString());
	  Order saved=this.orderRepo.save(order);
		
	 return this.mapper.map(saved,OrderResponse.class);
	}

	@Override
	public OrderResponse updateOrder(OrderResponse orderResponse, Integer orderId) {
		    Order order= this.orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("ID NOT FOUND !"));
		    order.setCustomerName(orderResponse.getCustomerName());
		    order.setOrderDate(orderResponse.getOrderDate());
		    order.setOrderId(orderResponse.getOrderId());
		    order.setPrice(orderResponse.getPrice());
		    order.setProduct(orderResponse.getProduct());
		    order.setQuantity(orderResponse.getQuantity());
		    order.setStatus(Status.CONFIRMED);
		    order.setTrackingId(orderResponse.getTrackingId());
		    order.setUpdatedDate(orderResponse.getUpdatedDate());
		    
		    Order orde=this.orderRepo.save(order);
		
		return this.mapper.map(orde, OrderResponse.class);
	}

	@Override
	public void DeleteOrder(Integer orderId) {
		
		 this.orderRepo.deleteById(orderId);
		
	}

	@Override
	public List<OrderResponse> listOfOrder() {
		      List<Order>order= this.orderRepo.findAll();
		      List<OrderResponse>resp=order.stream().map((ord)->this.mapper.map(ord,OrderResponse.class)).collect(Collectors.toList());
		return resp;
	}

	@Override
	public OrderResponse singleOrder(Integer orderId) {
		
		Order order=this.orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("ID NOT FOUND !"));	
	return this.mapper.map(order, OrderResponse.class);
	}

	
	//model mapper
	
	public Order OrderToDto(OrderResponse orderResponse) {
		         return this.mapper.map(orderResponse, Order.class);
		
	}
	public OrderResponse DtoToOrder(Order orderResponse) {
        return this.mapper.map(orderResponse, OrderResponse.class);

}
	
	
}
