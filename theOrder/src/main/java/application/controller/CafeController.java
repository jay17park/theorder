package application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.ShopDAO;
import application.vo.ShopVO;

@Controller
public class CafeController {
	@Autowired
    private ShopDAO shopDAO;
	
	@RequestMapping(value="/cafe.do", method=RequestMethod.POST)
	public String doCafeSelect(@RequestParam(value="cafe",defaultValue="1")String shopId, Model model, HttpSession session) {
		session.setAttribute("shopId", shopId);
        return "redirect:/selmenu";
	}
	@RequestMapping("/cafe")
	public String doCafeList(Model model, HttpSession session) {
		System.out.println(session.getAttribute("userId"));
		System.out.println(session.getAttribute("userNm"));
		List<ShopVO> shopList = shopDAO.selectRestOrder();
		System.out.println(shopList.toString());
		model.addAttribute("shops", shopList);
		return "cafe";
	}
}
