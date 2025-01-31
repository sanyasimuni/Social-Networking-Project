package com.suplier.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suplier.DTO.SupplierResponse;
import com.suplier.Entity.Supplier;
import com.suplier.Exception.ResourceNotFoundException;
import com.suplier.Repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepo supplierRepo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public SupplierResponse CreateSupplier(SupplierResponse supplierResponse) {
    
		Supplier supplier=this.mapper.map(supplierResponse, Supplier.class);
     
             supplier.setCreated(LocalDateTime.now());
             supplier.setUpdated(LocalDateTime.now());
             
                  Supplier saved= this.supplierRepo.save(supplier);
            
		return this.mapper.map(saved, SupplierResponse.class);
	}

	@Override
	public void deleteSupplier(Integer suplierId) {
		
		this.supplierRepo.deleteById(suplierId);
		
	}

	@Override
	public List<SupplierResponse> listOfSupplier() {
		         List<Supplier>supp= this.supplierRepo.findAll();
		         List<SupplierResponse>resp=supp.stream().map((err)->this.mapper.map(err, SupplierResponse.class)).collect(Collectors.toList());
		
		return resp;
	}
	
	public Supplier productToDto(SupplierResponse productResponse) {
		 return   this.mapper.map(productResponse, Supplier.class);
	}

	public SupplierResponse DtoToProduct(Supplier productResponse) {
		 return   this.mapper.map(productResponse, SupplierResponse.class);
	}

	@Override
	public SupplierResponse singleGetById(Integer suplierId) {
		
	Supplier supplier= this.supplierRepo.findById(suplierId).orElseThrow(()->new ResourceNotFoundException("Suplier ID Not Found!"));
		
		return this.mapper.map(supplier, SupplierResponse.class);
	}



}
