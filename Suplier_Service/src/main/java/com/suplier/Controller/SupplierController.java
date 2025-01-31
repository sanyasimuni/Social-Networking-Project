package com.suplier.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suplier.DTO.ApiResponse;
import com.suplier.DTO.SupplierResponse;
import com.suplier.Service.SupplierService;

@RestController
@RequestMapping("/api/suplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@PostMapping("/add")
	public ResponseEntity<SupplierResponse>createSupplier(@RequestBody SupplierResponse response){
	
		SupplierResponse resp=this.service.CreateSupplier(response);
		return new ResponseEntity<SupplierResponse>(resp,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<SupplierResponse>>ListSupplier(){
	
		List<SupplierResponse> resp=this.service.listOfSupplier();
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{suplierId}")
	public ResponseEntity<ApiResponse>DeleteSupplier(@PathVariable Integer suplierId){
	
		this.service.deleteSupplier(suplierId);
		return new ResponseEntity<>(new ApiResponse("ID Deleted Succes!",true),HttpStatus.OK);
	}
	
	@GetMapping("/{suplierId}")
	public ResponseEntity<SupplierResponse>SingleSupplier(@PathVariable Integer suplierId){
	
		      SupplierResponse sup=this.service.singleGetById(suplierId);
		return new ResponseEntity<>(sup,HttpStatus.OK);
	}
	

}
