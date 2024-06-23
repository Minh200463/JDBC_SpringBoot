package edu.poly.lab.lab7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.lab.model.Categories;
import edu.poly.lab.repository.CategoryRepository;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@RequestMapping("index")
	public String index(Model model) {
		return "lab7/index";
	}
	
	@RequestMapping("about")
	public String about() {
		return "lab7/about";
	}
	
}
