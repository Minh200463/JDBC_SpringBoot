package edu.poly.lab.service;

import java.util.List;
import java.util.Optional;

import edu.poly.lab.model.Categories;
import edu.poly.lab.repository.CategoryRepository;

public interface CategoryService {

	void deleteAll();

	void delete(Categories entity);

	Categories getById(Integer id);

	void deleteById(Integer id);

	long count();

	List<Categories> findAll();

	void flush();

	<S extends Categories> List<S> saveAll(Iterable<S> entities);

	<S extends Categories> S save(S entity);

	Optional<Categories> findById(Integer id);

}
