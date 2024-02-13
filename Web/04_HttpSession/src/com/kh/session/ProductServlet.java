package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 받아오기
		HttpSession session = request.getSession();
		
		// 2. 세션에 바인딩된 값이 있다면 그 값을 찾아온다
		Member member = (Member) session.getAttribute("info");
		
		if(member != null) {	// 로그인된 상태
			System.out.println(member);
			request.setAttribute("product", "notebook");
			request.getRequestDispatcher("CartServlet").forward(request, response);
			// request, response를 보내고 안 보내고의 차이
			// 페이지 이동만 하면 redirect
//			response.sendRedirect("CartServlet");
		}
	}

}
