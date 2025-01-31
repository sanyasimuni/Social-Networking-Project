package com.prodict.Controller;

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

import com.prodict.DTO.ProductResponse;
import com.prodict.Entity.ApiResponse;
import com.prodict.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<ProductResponse>AddProduct(@Valid @RequestBody ProductResponse productResponse){
		
		            ProductResponse resp=this.productService.addProduct(productResponse);
		            
		            return new ResponseEntity<ProductResponse>(resp,HttpStatus.CREATED);
//		            if(resp!=null) {
//		            	return new ResponseEntity<ProductResponse>(resp,HttpStatus.CREATED);
//		           }
//		            return new ResponseEntity<>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	}
	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductResponse>UpdateProduct(@RequestBody ProductResponse productResponse,
			@PathVariable Integer productId){
		
		       ProductResponse resp=this.productService.updateProduct(productResponse, productId);
		            
	return new ResponseEntity<ProductResponse>(resp,HttpStatus.OK);
		          
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductResponse>>ListOfProduct(){
		
		List<ProductResponse>list=this.productService.listOfProduct();
		return new ResponseEntity<List<ProductResponse>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse>singleProduct(@PathVariable Integer productId){
		
		ProductResponse single =this.productService.singleProduct(productId);
		return new ResponseEntity<>(single,HttpStatus.OK);
		
	}
	
   @DeleteMapping("/{productId}")
   public ResponseEntity<ApiResponse>DeleteProduct(@PathVariable Integer productId){
		
		this.productService.DeleteProduct(productId);
		return new ResponseEntity<>(new ApiResponse("Id Delete Success !",true),HttpStatus.OK);
		
	}
   
   
   @GetMapping("/supplier/{suplierId}")
	public ResponseEntity<List<ProductResponse>>FindSupplierById(@PathVariable Integer suplierId){
		
		List<ProductResponse>list   =this.productService.ListOfSuplierById(suplierId);
		return new ResponseEntity<List<ProductResponse>>(list,HttpStatus.OK);
		
	}
   
   
   @GetMapping("/order/{ordreId}")
  	public ResponseEntity<List<ProductResponse>>FindOrderById(@PathVariable Integer ordreId){
  		
  		List<ProductResponse>list   =this.productService.ListOfOrderById(ordreId);
  		return new ResponseEntity<List<ProductResponse>>(list,HttpStatus.OK);
  		
  	}
	
   
	

}
