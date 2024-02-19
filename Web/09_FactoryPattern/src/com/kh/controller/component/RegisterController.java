package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;

import model.dao.MemberDAO;
import model.vo.Member;

public class RegisterController implements Controller {

	// 강제성 부여했으니까 그것 가져와서 오버라이딩하면 됨.
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 비즈니스 로직이 오는 곳
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.registerMember(member);
		
		// sendRedirect로 전송했기 때문에 path만 넣어서 객체 생성
		return new ModelAndView("index.jsp", true);
	}
	
}
