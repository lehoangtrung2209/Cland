package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.RoleDAO;
import dao.UserDAO;
import model.User;

@Controller
@RequestMapping("admin/users")
public class AdminUserController {
	@Autowired
	private Defines defines;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("listRole", roleDAO.getItems());
	}

	@RequestMapping("")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listUser", userDAO.getItems());
		return "admin.user.index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.user.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user") User user, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.user.add";
		}
		User u = userDAO.getUser(user.getUsername());
		if (u != null) {
			ra.addFlashAttribute("err", "Trùng username");
			return "redirect:/admin/users";
		}
		user.setPassword(encoder.encode(user.getPassword()));
		if (userDAO.addItem(user) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "del/{id}", method = RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		User user = userDAO.getItem(id);
		if (defines.getSuperAdmin().equals(user.getUsername())) {
			// không được xóa admin
			ra.addFlashAttribute("msg", Defines.BAD_REQUEST);
			return "redirect:/admin/users";
		}
		if (userDAO.delItem(id) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("user", userDAO.getItem(id));
		return "admin.user.edit";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("user") User user, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.user.edit";
		}
		user.setId(id);
		if ("".equals(user.getPassword())) {
			// lấy lại mật khẩu cũ
			user.setPassword(userDAO.getItem(id).getPassword());
		}
		else {
		user.setPassword(encoder.encode(user.getPassword())); //
		}
		if (userDAO.editItem(user) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/users";
	}
}
