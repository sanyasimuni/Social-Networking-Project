package com.prodict.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodict.Entity.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
	

	    public List<Product> findBySuplierId(Integer suplierId);

	    public List<Product> findByOrdreId(Integer ordreId);
	
}
