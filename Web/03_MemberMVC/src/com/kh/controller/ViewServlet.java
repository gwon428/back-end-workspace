package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// SELECT
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		// dao.showAllMember() : ArrayList<Member> <-- list로 담아서
		try {
			list = dao.showAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 2. 바인딩 : list 자체로 전체 바인딩
		// setAttribute
		request.setAttribute("list", list);
		System.out.println(list);
		
		// 3. 네비게이션
		request.getRequestDispatcher("view.jsp").forward(request, response);

	}

}
