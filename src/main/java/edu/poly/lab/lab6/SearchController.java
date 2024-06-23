package edu.poly.lab.lab6;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.lab.model.Products;
import edu.poly.lab.repository.ProductRepository;
import edu.poly.lab.service.ProductService;

@Controller
@RequestMapping("product")
public class SearchController {
	@Autowired
	ProductRepository productrepositoy;
	
	@RequestMapping("search")
	public String search(Model model, @RequestParam("min") Optional<Float> min,@RequestParam("max") Optional<Float> max ) {
		float minprice = min.orElse(Float.MIN_VALUE);
		float maxprice = max.orElse(Float.MAX_VALUE);
		List<Products> items = productrepositoy.findByPrice(minprice, maxprice);
		model.addAttribute("items", items);
		return "lab6/search";
	}
}
