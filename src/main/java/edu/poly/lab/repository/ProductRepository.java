package edu.poly.lab.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.lab.model.Products;
import edu.poly.lab.model.Report;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	@Query("SELECT o FROM Products o WHERE o.price BETWEEN ?1 AND ?2")
	List<Products> findByPrice(double minPrice, double maxPrice);
	
//	DSL
	List<Products> findByPriceBetween(float minPrice, float maxPrice);
	
	
	@Query("SELECT o FROM Products o WHERE o.name LIKE ?1")
	Page<Products> findByKeywords(String key, Pageable pageable);
	
//	DSL
	Page<Products> findAllByNameLike(String keywords, Pageable pageable);
	
	
	@Query("SELECT new edu.poly.lab.model.Report(o.categories.name, sum(o.price), count(o)) FROM Products o GROUP BY o.categories.name ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();
}
