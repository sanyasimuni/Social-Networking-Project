package com.order.Services;

import java.util.List;

import com.order.DTO.OrderResponse;

public interface OrderService {
	
	//order
	public OrderResponse addOrder(OrderResponse orderResponse );
	
	//update
	public OrderResponse updateOrder(OrderResponse orderResponse,Integer orderId);
	
	//delete
    void DeleteOrder(Integer orderId);
    
    public List<OrderResponse>listOfOrder();
    
    //single Order
    public OrderResponse singleOrder(Integer orderId);
    
    //Status
    
    
    
    
  
	

}
