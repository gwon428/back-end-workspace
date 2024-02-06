package com.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.html에서 /register로 서버에 요청을 하여
		//			==> <form action="register">
		// 요청 받은 이름, 나이, 주소를 받아서
		//			==> request.getParameter("name");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		//			==> 폼 태그의 name을 통해 Servlet에서 parameter를 찾아 value값을 가져오는 것
		//			==> web.xml에 등록해서 연결?
		PrintWriter pw = response.getWriter();
		// result.jsp 파일로 해당 정보 출력
		//			==> WebContent -> /를 통해 바로 접근이 가능
		// ==> jsp에 <% request.getParameter("name") %>로 출력될 html 저장
		// result.jsp 페이지로 링크 연결
		pw.println("<a href='result.jsp?name=" + name + "&age=" + age + "&addr=" + addr + "'>결과 확인</a>");

		// <a href='result.jsp'>결과 확인</a> <-- 이 링크를 눌렀을 시 해당 result.jsp 페이지에서
		// '주소'에 사는 '나이'세인 '이름' 가입 완료! << h1 태그를 이용해서 출력
		pw.close();
		
		
		
		
		
	
	}

}
