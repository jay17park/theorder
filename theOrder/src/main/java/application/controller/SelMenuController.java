package application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.dao.MenuDAO;
import application.vo.MenuVO;

@Controller
public class SelMenuController {
	
	@Autowired
	private MenuDAO menuDao;
	
	@RequestMapping("/selmenu")
	public String selMenu(Model model) {
		
		List<MenuVO> menuList = menuDao.select();
		
		model.addAttribute("menuList", menuList);
		
		return "SelMenu";
	}
}
