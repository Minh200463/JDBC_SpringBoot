package edu.poly.lab.lab6;

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
import edu.poly.lab.repository.ProductRepository;
import edu.poly.lab.service.SessionService;

@Controller
@RequestMapping("bai5")
public class Bai5Controller {
	
	@Autowired
	ProductRepository prdrepository;
	
	@Autowired
	SessionService session;
	
	@RequestMapping("searchpage")
	public String bai5(Model model, @RequestParam("keyword") Optional<String> kw, @RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords", ""));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0),3);
		Page<Products> page = prdrepository.findAllByNameLike("%"+kwords+"%", pageable);
		model.addAttribute("page", page);
		return "lab6/bai5";
	}
}
