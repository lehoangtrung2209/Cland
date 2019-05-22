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
import dao.BlockDAO;
import dao.ProjectDAO;
import model.Block;

@Controller
@RequestMapping("admin/blocks")
public class AdminBlockController {
	@Autowired
	private Defines defines;

	@Autowired
	private BlockDAO blockDAO;
	
	@Autowired
	private ProjectDAO projectDAO;

	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}

	@RequestMapping("")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listItem", blockDAO.getItems());
		return "admin.block.index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listProject", projectDAO.getItems());
		return "admin.block.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("block") Block block, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.block.add";
		}
		if (blockDAO.addItem(block) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/blocks";
	}

	@RequestMapping(value = "del/{id}", method = RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if (blockDAO.delItem(id) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/blocks";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("block", blockDAO.getItem(id));
		modelMap.addAttribute("listProject", projectDAO.getItems());
		return "admin.block.edit";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("block") Block block, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "admin.block.edit";
		}
		block.setId(id);
		if (blockDAO.editItem(block) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/blocks";
	}
}
