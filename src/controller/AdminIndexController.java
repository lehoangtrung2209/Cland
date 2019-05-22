package controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import dao.UserDAO;
import model.User;

@Controller
@RequestMapping("admin")
public class AdminIndexController {
	@Autowired
	private Defines defines;
	
	@Autowired
	private UserDAO userDAO;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(Principal principal, HttpSession session){
		User userLogin = userDAO.getItem(principal.getName());
		session.setAttribute("userLogin", userLogin);
		return "admin.index.index";
	}
}
