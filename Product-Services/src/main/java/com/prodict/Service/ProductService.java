package com.prodict.Service;

import java.util.List;

import com.prodict.DTO.ProductResponse;


public interface ProductService {
	
	//add product
	public   ProductResponse addProduct(ProductResponse productResponse);
	
	//update Product
	
	public ProductResponse updateProduct(ProductResponse productResponse,Integer productId);
	
	//list of get
	public List<ProductResponse>listOfProduct();
	
	//single get
	public ProductResponse singleProduct(Integer productId);
	
	//delete
	
	public void DeleteProduct(Integer productId);
	
	//list of Supplier By ID
	
	public List<ProductResponse>ListOfSuplierById(Integer suplierId);
	//list of Order By Id
	public List<ProductResponse>ListOfOrderById(Integer ordreId);

}
