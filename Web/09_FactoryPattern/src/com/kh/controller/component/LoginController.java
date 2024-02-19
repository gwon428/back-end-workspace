package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;

import model.dao.MemberDAO;
import model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getParameter("id");
		String password = (String) request.getParameter("password");

		MemberDAO dao = new MemberDAO();
		Member member = dao.LogIn(id, password);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		// session에 바인딩 -> 서버에 끝날 때까지 저장되어 있기 때문에 
		return new ModelAndView("views/login_result.jsp", true);
		
	}

}
