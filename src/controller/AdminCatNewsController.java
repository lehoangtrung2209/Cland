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
import dao.CategoryNewsDAO;
import dao.ProjectDAO;
import model.CategoryNews;

@Controller
@RequestMapping("admin/catnews")
public class AdminCatNewsController {
	@Autowired
	private Defines defines;
	
	@Autowired
	private CategoryNewsDAO categorynewsDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(ModelMap modelMap){
		modelMap.addAttribute("listCategory", categorynewsDAO.getItems());
		return "admin.catnews.index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(){
		return "admin.catnews.add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute ("category") CategoryNews cat,BindingResult br, RedirectAttributes ra){
		if (br.hasErrors()) {
			return "admin.catnews.add";
		}
		if (categorynewsDAO.addItem(cat) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/catnews";
	}
	
	@RequestMapping(value="del/{id}", method=RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if (categorynewsDAO.delItem(id) > 0) {
			projectDAO.delItemByCate(id);
			//xóa những tin thuộc danh mục
			//detele(id) where cid = id
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/catnews";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("category", categorynewsDAO.getItem(id));
		return "admin.catnews.edit";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("category") CategoryNews category,BindingResult br,RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.catnews.edit";
		}
		category.setId(id);
		if (categorynewsDAO.editItem(category) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/catnews";
	}
}
