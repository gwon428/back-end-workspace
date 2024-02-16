package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.vo.Member;
//*.do : .do로 끝나는 모든 것들을 접속
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("requestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		// 사용자가 어떤 기능을 요구받는지 받는 주문서
		String command = requestURIList[requestURIList.length-1];
		
		// 주문한 것에 따라 기능이 들어간 컨트롤러(컴포넌트) 생성
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			// 각 컴포넌트의 비즈니스 로직 실행
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				} else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
