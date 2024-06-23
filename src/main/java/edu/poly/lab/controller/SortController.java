package edu.poly.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.lab.model.Products;
import edu.poly.lab.repository.ProductRepository;
import edu.poly.lab.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("product")
public class SortController {
	@Autowired
	ProductRepository productrepository;

	
	@RequestMapping("sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		model.addAttribute("field", field.orElse("price").toUpperCase());
		List<Products> items = productrepository.findAll(sort);
		model.addAttribute("items", items);
		return "product/index";
	}
	
}
