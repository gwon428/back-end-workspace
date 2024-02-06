package servlet.life;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifecycleServlet() {
		System.out.println("LifecycleServlet 생성자 호출");
	}
	
	// Servlet = Generic Servlet(기능 관련 - HttpServlet) + ServletConfig(설정 관련 코드들이 담겨있음)
	public void init(ServletConfig config) throws ServletException {
		// 처음 로드됐을 때 발생
		// ServletConfig -> 가장 먼저 올라온다 (?
		System.out.println("init 호출");
	}

	public void destroy() {
		// 서버가 꺼지는 순간에 발생
		System.out.println("destroy 호출");
	}

	// 1. service에 구현
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// doGet + doPost = service 라고 봐도 무방함.
//		System.out.println("서비스 호출");			// 서비스 호출 방식이 있으면 doGet/doPost 를 사용할 수 X
//	}

	// 2. doGet에 구현 (service와 doGet/doPost 중 1)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");			//http://localhost:8080/life?name=1234
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");		//http://localhost:8080/lifecycle.html 파일을 만들어 post 형식으로 전송
		doGet(request, response);
	}

}
