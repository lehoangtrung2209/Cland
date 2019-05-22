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
import model.Category;

@Controller
@RequestMapping("admin/cats")
public class AdminCatController {
	@Autowired
	private Defines defines;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(ModelMap modelMap){
		modelMap.addAttribute("listCategory", categoryDAO.getItems());
		return "admin.cat.index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(){
		return "admin.cat.add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute ("category") Category cat,BindingResult br, RedirectAttributes ra){
		if (br.hasErrors()) {
			return "admin.cat.add";
		}
		if (categoryDAO.addItem(cat) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/cats";
	}
	
	@RequestMapping(value="del/{id}", method=RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if (categoryDAO.delItem(id) > 0) {
			projectDAO.delItemByCate(id);
			//xóa những tin thuộc danh mục
			//detele(id) where cid = id
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/cats";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("category", categoryDAO.getItem(id));
		return "admin.cat.edit";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("category") Category category,BindingResult br,RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.cat.edit";
		}
		category.setId(id);
		if (categoryDAO.editItem(category) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/cats";
	}
}
