package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.CategoryNewsDAO;
import dao.NewsDAO;
import model.News;
import util.FileUtil;

@Controller
@RequestMapping("admin/news")
public class AdminNewsController {
	@Autowired
	private Defines defines;

	@Autowired
	private NewsDAO newsDAO;

	@Autowired
	private CategoryNewsDAO categoryNewsDAO;

	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}

	@RequestMapping(value = { "", "{page}" })
	public String index(@PathVariable(required = false) Integer page, ModelMap modelMap) {
		if (page == null) {
			page = 1;
		}
		// tổng số tin
		int totalNews = newsDAO.countItems();
		// số trang
		int sumPages = (int) Math.ceil((float) totalNews / Defines.ROW_COUNT_ADMIN);
		
		int pageStart, pageEnd;
		int pageNum = 5;
		int linkPage = (int) Math.floor((float) page / 2);

		modelMap.addAttribute("sumPages", sumPages);
		modelMap.addAttribute("page", page);
		int offset = (page - 1) * Defines.ROW_COUNT_ADMIN;
		modelMap.addAttribute("listNews", newsDAO.getItems(offset));
		
		if ((page > 1) && (sumPages > 0)) {
			modelMap.addAttribute("previous", (page - 1));
		}

		if (page > 5) {
			pageStart = page - linkPage;
			if (sumPages > page + linkPage) {
				pageEnd = sumPages + linkPage;
			} else if (page <= sumPages && page > sumPages - (pageNum - 1)) {
				pageStart = sumPages - (pageNum - 1);
				pageEnd = sumPages;
			} else {
				pageEnd = sumPages;
			}
		} else {
			pageStart = 1;
			if (5 < sumPages) {
				pageEnd = 5;
			} else {
				pageEnd = sumPages;
			}
		}
		modelMap.addAttribute("pageStart", pageStart);
		modelMap.addAttribute("pageEnd", pageEnd);

		if (page < sumPages && sumPages > 1) {
			// Button trang sau
			modelMap.addAttribute("next", (page + 1));
		}
		
		return "admin.news.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listCategory", categoryNewsDAO.getItems());
		return "admin.news.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("hinhanh") CommonsMultipartFile cmf,@Valid @ModelAttribute("news") News news,
			BindingResult br,ModelMap modelMap, HttpServletRequest request, RedirectAttributes ra) {
		if (br.hasErrors()) {
			modelMap.addAttribute("listCategory", categoryNewsDAO.getItems());
			return "admin.news.add";
		}
		try {
			FileUtil.upload(cmf, request);
		} catch (IOException e) {
			ra.addFlashAttribute("msg", Defines.ERROR);
			return "redirect:/admin/news";
		}
		news.setPicture(FileUtil.getFileName());
		if (newsDAO.addItem(news) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("err", Defines.ERROR);
		}
		return "redirect:/admin/news";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		News news = newsDAO.getItem(id);
		modelMap.addAttribute("news", news);
		modelMap.addAttribute("listCategory", categoryNewsDAO.getItems());
		return "admin.news.edit";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable("id") int id,@Valid @ModelAttribute("news") News news,BindingResult br,
			@RequestParam("hinhanh") CommonsMultipartFile cmf, ModelMap modelMap, HttpServletRequest request,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			modelMap.addAttribute("listCategory", categoryNewsDAO.getItems());
			return "admin.news.edit";
		}
		News newsOld = newsDAO.getItem(id);
		String fileNameOld = newsOld.getPicture();
		String fileName = cmf.getOriginalFilename();
		String fileNameNew = "";
		if (!"".equals(fileName)) {

			// xử lý upload file
			try {
				FileUtil.upload(cmf, request);
				fileNameNew = FileUtil.getFileName();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				// xóa hình ảnh cũ
				if (!"".equals(fileNameOld)) {
					FileUtil.delete(fileNameOld, request);
				}
			} catch (IOException e) {
				return "redirect:/admin/news";
			}
		} else {
			fileNameNew = fileNameOld;
		}
		news.setPicture(fileNameNew);
		news.setId(id);
		if (newsDAO.editItem(news) > 0) {
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value="del/{id}", method=RequestMethod.GET)
	public String del(@PathVariable("id") int id,HttpServletRequest request, RedirectAttributes ra) {
		String fileName = newsDAO.getItem(id).getPicture();
		if (newsDAO.delItem(id) > 0) {
			try {
				FileUtil.delete(fileName, request);
			} catch (IOException e) {
				ra.addFlashAttribute("msg", Defines.ERROR);
				return "redirect:/admin/news";
			}
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/news";
	}
}
