package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count = 0;
	
	private String name;
	private String addr;
	
	public void init(ServletConfig config) throws ServletException {
		// Config -> 설정과 관련된 코드들이 들어가있음 (설정은 web.xml에서 주로 함) -> 이걸 config에서 받을 수 있음 ?엥
		name = config.getInitParameter("name");		// init일 때 => web.xml에서 지정한 것을 getInitParameter를 통해 가져옴
		addr = config.getInitParameter("addr");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<h2> 이름 : " + name + "</h2>");
		pw.println("<h2> 주소 : " + addr + "</h2>");
		pw.println("<a href='config.jsp?name="+ name + "&count=" + ++count + "'>config.jsp로 이동</a>");
												// get 방식은 '공백'도 인식하니까 주의
		
		pw.close();
	}

}
