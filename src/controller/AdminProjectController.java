package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.CategoryDAO;
import dao.ProjectDAO;
import model.Project;

@Controller
@RequestMapping("admin/projects")
public class AdminProjectController {
	@Autowired
	private Defines defines;

	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}

	@RequestMapping("")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listItem", projectDAO.getItems());
		return "admin.project.index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listCategory", categoryDAO.getItems());
		return "admin.project.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("project") Project project, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.project.add";
		}
		if (projectDAO.addItem(project) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(value = "del/{id}", method = RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if (projectDAO.delItem(id) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("project", projectDAO.getItem(id));
		modelMap.addAttribute("listCategory", categoryDAO.getItems());
		return "admin.project.edit";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("project") Project project, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.project.edit";
		}
		project.setId(id);
		if (projectDAO.editItem(project) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/projects";
	}
}
