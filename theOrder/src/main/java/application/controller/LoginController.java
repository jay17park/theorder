package application.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.UserDAO;
import application.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
    private UserDAO userDAO;
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String doLogin(String id, String regId, String pass, Model model, HttpSession session) {
		System.out.println("Id : " + id);
		System.out.println("Pass : " + pass);
		System.out.println("regId : " + regId);
		UserVO inUserVO = new UserVO(id, pass);
		UserVO userVO = userDAO.selectUser(inUserVO);
		System.out.println(userVO.toString());
		System.out.println(regId);
		if(userVO != null && userVO.getCnt() > 0) {
			//TODO : 세션 세팅
			System.out.println("로그인!!");
			inUserVO.setUserRegId(regId);
			System.out.println(inUserVO);
			int result = userDAO.updateUserRegId(inUserVO);
			System.out.println(result);
			model.addAttribute("error", "N");
			session.setAttribute("userId", userVO.getUserId());
			session.setAttribute("userNm", userVO.getUserNm());
			return "redirect:cafe";
		} else {
			//로그인 오류인 경우 error 전달
			System.out.println("에러로 왜와?");
			model.addAttribute("error", "Y");
			return "login";
		}
	}
}
