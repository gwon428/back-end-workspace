package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// URL mapping
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.폼 값 받아오기
		String name = request.getParameter("name");
		
		// 2. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.searchMember(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 바인딩
		request.setAttribute("member", member);
		
		// 4. 네비게이션 (만약 멤버 정보가 없을 경우 추가)
		if(member != null) {
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
		
	}

}
