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


@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Member> list = null;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		try {
			dao.allShow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/allShow.jsp").forward(request, response);
		
	}

}
