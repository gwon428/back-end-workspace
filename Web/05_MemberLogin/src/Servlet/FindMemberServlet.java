package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.vo.Member;

@WebServlet("/search")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		Member member = null;
		
		try {
			member = dao.findMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/views/find_ok.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/find_fail.jsp");
		}
	}

}
