package com.prodict.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prodict.DTO.OrderResponse;
import com.prodict.DTO.ProductResponse;
import com.prodict.DTO.SupplierResponse;
import com.prodict.Entity.Product;
import com.prodict.Entity.Status;
import com.prodict.Exception.ResourceNotFoundException;
import com.prodict.Repo.ProductRepository;

@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate  restTemplate;
	
	
	@Override
	public ProductResponse addProduct(ProductResponse productResponse) {
		         
    Product product=this.mapper.map(productResponse, Product.class);
    product.setDate(LocalDateTime.now());
    product.setStatus(Status.PENDING);
    product.setSuplierId(productResponse.getSuplierId());
    product.setOrdreId(productResponse.getOrdreId());
    Product saved=this.productRepository.save(product);
    
		return this.mapper.map(saved, ProductResponse.class);
	}

	@Override
	public ProductResponse updateProduct(ProductResponse productResponse, Integer productId) {
		 
		           Product p=this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("ID NOT FOUND WITH !"));
		           p.setProductName(productResponse.getProductName());
		           p.setQuantity(productResponse.getQuantity());
		           p.setDescription(productResponse.getDescription());
		           p.setPrice(productResponse.getPrice());
		           p.setDate(LocalDateTime.now());
		           p.setStatus(Status.PENDING);
		           p.setSuplierId(productResponse.getSuplierId());
		           p.setOrdreId(productResponse.getOrdreId());
		           
		 Product saved=this.productRepository.save(p);
		
		return this.mapper.map(saved, ProductResponse.class);
	}

	@Override
	public List<ProductResponse> listOfProduct() {
		        List<Product>pp= this.productRepository.findAll();
		        List<ProductResponse>resp=pp.stream().map((ppp)->this.mapper.map(ppp,ProductResponse.class)).collect(Collectors.toList());
		return resp;
	}

	@Override
	public ProductResponse singleProduct(Integer productId) {
		
		
				
    Product product=this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("ID NOT FOUND WITH !"));
		
     
	 OrderResponse response=this.restTemplate.getForObject("http://localhost:8090/api/order/"+product.getOrdreId(),OrderResponse.class);
		 
	 SupplierResponse resp=this.restTemplate.getForObject("http://localhost:8090/api/order/"+product.getSuplierId(),SupplierResponse.class);
		
		 ProductResponse productResponse=new ProductResponse();
		 productResponse.setOrderResponse(response);
		 productResponse.setSupplierResponse(resp);
		 
		 return this.mapper.map(productResponse, ProductResponse.class);
	}

	@Override
	public void DeleteProduct(Integer productId) {
    this.productRepository.deleteById(productId);
		   
		
	}
	//model mapper
	
	public Product productToDto(ProductResponse productResponse) {
		 return   this.mapper.map(productResponse, Product.class);
	}

	public ProductResponse DtoToProduct(Product productResponse) {
		 return   this.mapper.map(productResponse, ProductResponse.class);
	}

	@Override
	public List<ProductResponse> ListOfSuplierById(Integer suplierId) {
		
		List<Product>product=this.productRepository.findBySuplierId(suplierId);
		
		List<ProductResponse>response=product.stream().map((ppp)->this.mapper.map(ppp,ProductResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public List<ProductResponse> ListOfOrderById(Integer ordreId) {
	    List<Product>product=this.productRepository.findByOrdreId(ordreId);
		
		List<ProductResponse>response=product.stream().map((ppp)->this.mapper.map(ppp,ProductResponse.class)).collect(Collectors.toList());
		return response;
	}



}
