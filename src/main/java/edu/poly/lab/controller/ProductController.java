package edu.poly.lab.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.lab.model.Products;
import edu.poly.lab.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productservice;
	
	@RequestMapping("page")
	public String pagination(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pagable = PageRequest.of(p.orElse(0), 3);
		Page<Products> page = productservice.findAll(pagable);
		System.out.println("Page: "+page.getNumber());
		System.out.println("Page: "+page.getSize());
		System.out.println("Page: "+page.getNumberOfElements());
		System.out.println("Page: "+page.getTotalElements());
		System.out.println("Page: "+page.getTotalPages());
		model.addAttribute("page", page);
		return "product/pagination";
	}
}
