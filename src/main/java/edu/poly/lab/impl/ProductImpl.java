package edu.poly.lab.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.lab.model.Products;
import edu.poly.lab.repository.ProductRepository;
import edu.poly.lab.service.ProductService;

@Service
public class ProductImpl implements ProductService{
	ProductRepository productrepositoy;

	public ProductImpl(ProductRepository productrepositoy) {
		this.productrepositoy = productrepositoy;
	}

	@Override
	public <S extends Products> S save(S entity) {
		return productrepositoy.save(entity);
	}

	@Override
	public <S extends Products> List<S> saveAll(Iterable<S> entities) {
		return productrepositoy.saveAll(entities);
	}

	@Override
	public void flush() {
		productrepositoy.flush();
	}

	@Override
	public List<Products> findAll() {
		return productrepositoy.findAll();
	}

	@Override
	public Optional<Products> findById(Integer id) {
		return productrepositoy.findById(id);
	}

	@Override
	public long count() {
		return productrepositoy.count();
	}

	@Override
	public void deleteById(Integer id) {
		productrepositoy.deleteById(id);
	}

	@Override
	public Products getById(Integer id) {
		return productrepositoy.getById(id);
	}

	@Override
	public void deleteAll() {
		productrepositoy.deleteAll();
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		return productrepositoy.findAll(pageable);
	}
	
	
	
}
