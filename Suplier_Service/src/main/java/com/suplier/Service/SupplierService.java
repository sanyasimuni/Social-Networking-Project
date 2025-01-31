package com.suplier.Service;

import java.util.List;

import com.suplier.DTO.SupplierResponse;

public interface SupplierService {
	
	//create SUpplier
	public SupplierResponse CreateSupplier(SupplierResponse supplierResponse);
	
	//delete Supplier
	public void deleteSupplier(Integer suplierId);
	
	//list
	public List<SupplierResponse>listOfSupplier();
	
	public SupplierResponse singleGetById(Integer suplierId );
	

}
