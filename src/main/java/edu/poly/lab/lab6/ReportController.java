package edu.poly.lab.lab6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.lab.model.Report;
import edu.poly.lab.repository.ProductRepository;

@Controller
@RequestMapping("product")
public class ReportController {
	@Autowired
	ProductRepository prdrepository;
	
	
	@RequestMapping("report")
	public String report(Model model) {
		List<Report> items = prdrepository.getInventoryByCategory();
		model.addAttribute("items", items);
		return "lab6/report";
	}
}
