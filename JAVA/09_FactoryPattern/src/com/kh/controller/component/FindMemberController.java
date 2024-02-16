package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;

import model.dao.MemberDAO;
import model.vo.Member;

public class FindMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		Member member = dao.findMember(id);
		
		if(member != null) {
			request.setAttribute("member", member);
			return new ModelAndView("/views/find_ok.jsp");
		} else {
			return new ModelAndView("/views/find_fail.jsp", true);
		}
	}

}
