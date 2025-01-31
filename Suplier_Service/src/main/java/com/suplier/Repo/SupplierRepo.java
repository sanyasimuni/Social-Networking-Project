package com.suplier.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suplier.Entity.Supplier;

@Repository
public interface SupplierRepo  extends JpaRepository<Supplier, Integer>{
	


}
