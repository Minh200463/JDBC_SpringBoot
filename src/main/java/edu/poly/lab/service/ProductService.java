package edu.poly.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.poly.lab.model.Products;

public interface ProductService {

	void deleteAll();

	Products getById(Integer id);

	void deleteById(Integer id);

	long count();

	Optional<Products> findById(Integer id);

	List<Products> findAll();

	void flush();

	<S extends Products> List<S> saveAll(Iterable<S> entities);

	<S extends Products> S save(S entity);

	Page<Products> findAll(Pageable pageable);

}
