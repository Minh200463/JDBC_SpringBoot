package edu.poly.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.lab.model.Categories;
import edu.poly.lab.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryService categoryservice;

	@RequestMapping("index")
	public String index(Model model) {
		Categories item = new Categories();
		model.addAttribute("items", item);
		List<Categories> items = categoryservice.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Categories items = categoryservice.getById(id);
		model.addAttribute("item", items);
		return "forward:/category/index";
	}
	
	@RequestMapping("create")
	public String create(Categories item) {
		categoryservice.save(item);
		return "redirect:/category/index";
	}

	@RequestMapping("update")
	public String update(Categories item) {
		categoryservice.save(item);
		return "redirect:/category/edit/" + item.getId();
	}

	@RequestMapping("delete/{id}")
	public String create(@PathVariable("id") Integer id) {
		categoryservice.deleteById(id);
		return "redirect:/category/index";
	}

}
