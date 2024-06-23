package edu.poly.lab.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.poly.lab.model.Categories;
import edu.poly.lab.repository.CategoryRepository;
import edu.poly.lab.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	CategoryRepository categoryrepository;

	public CategoryImpl(CategoryRepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}

	public <S extends Categories> S save(S entity) {
		return categoryrepository.save(entity);
	}

	public <S extends Categories> List<S> saveAll(Iterable<S> entities) {
		return categoryrepository.saveAll(entities);
	}

	public void flush() {
		categoryrepository.flush();
	}

	public List<Categories> findAll() {
		return categoryrepository.findAll();
	}

	public long count() {
		return categoryrepository.count();
	}

	public void deleteById(Integer id) {
		categoryrepository.deleteById(id);
	}

	public Categories getById(Integer id) {
		return categoryrepository.getById(id);
	}

	public void delete(Categories entity) {
		categoryrepository.delete(entity);
	}

	public void deleteAll() {
		categoryrepository.deleteAll();
	}

	@Override
	public Optional<Categories> findById(Integer id) {
		return categoryrepository.findById(id);
	}
	
}
