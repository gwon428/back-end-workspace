package com.kh.controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;

import model.dao.MemberDAO;
import model.vo.Member;

public class AllShowController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = dao.allShow();
		request.setAttribute("list", list);
		return new ModelAndView("/views/allShow.jsp");
	}

}
