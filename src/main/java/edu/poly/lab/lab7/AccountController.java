package edu.poly.lab.lab7;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.lab.model.Accounts;
import edu.poly.lab.repository.AccountRepository;
import edu.poly.lab.service.SessionService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountRepository accrepository;
	
	@Autowired
	SessionService session;
	
	@GetMapping("login")
	public String login() {
		return "lab7/login";
	}
	
	 @PostMapping("login")
	    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
	        try {
	            Accounts user = accrepository.getOne(username);
	            if (user != null && user.getPassword().equals(password)) {
	                session.set("user", user);
	                String uri = session.get("security-uri", null);
	                System.out.println("URI : "+uri);
	                System.out.println("User : "+user);
	                if (uri != null && !uri.isEmpty()) {
//	                	if(uri.contains("/admin")) {
//	                		return "redirect:/account/admin";
//	                	}else if(uri.contains("/index")) {
//	                		return "redirect:/account/index";
//	                	}
	                    return "redirect:" + uri;
	                } else {
	                    model.addAttribute("message", "Login success!");
	                    return "redirect:/account/index";
	                }
	            } else {
	                model.addAttribute("message", "Invalid username or password");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("message", "Error occurred!");
	        }
	        return "lab7/login";
	    }
	
	
	@ResponseBody
	@RequestMapping("index")
	public String home() {
		return "Index page";
	}
	
	@ResponseBody
	@RequestMapping("admin")
	public String admin() {
		return "Admin page";
	}
	
	@ResponseBody
	@RequestMapping("logout")
	public String logout() {
		session.remove("user");
		session.remove("security-uri");
		String uri = session.get("security-uri", null);
		System.out.println("LogoutBefore: "+uri);
		return "Đăng xuất";
	}
	
}
