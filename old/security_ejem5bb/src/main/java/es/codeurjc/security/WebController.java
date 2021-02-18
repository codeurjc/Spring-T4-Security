package es.codeurjc.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }

    @GetMapping("/private")
    public String privatePage(Model model, HttpServletRequest request) {
    	
    	//model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	//model.addAttribute("username", request.getUserPrincipal().getName());
    	
    	return "private";
    }
    
    @GetMapping("/admin")
    public String admin() {
    	return "admin";
    }
}
