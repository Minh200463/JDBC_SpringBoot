package edu.poly.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.lab.model.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
