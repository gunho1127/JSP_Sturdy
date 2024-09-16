package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public LoginServlet(/*String servletName*/) {
        //super();
        // TODO Auto-generated constructor stub
    	//System.out.println("===> LoginServlet 생성");
    	//System.out.println("===> " + servletName + "  생성");
   // }
    
	//@Override
	//public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		//System.out.println("---> init() 호출");
	//}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		// 3. 응답 화면 구성 
		// 응답 메시지에 대한 인코딩 설정 
		response.setContentType("text/html;charset=UTF-8");
		
		// HTTP 응답 프로토콜 message-body와 연결된 출력 스트림 획득
		PrintWriter out = response.getWriter();
		
		// 메시지 출력
		if (user != null) {
			//비밀번호 체크
			if (user.getPassword().equals(password)) {  // 로그인 성공한 경우
				
				// 상태 정보를 세션에 저장합니다.
				HttpSession session = request.getSession();	
				//session.setMaxInactiveInterval(10);
				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getName());
				session.setAttribute("userRole", user.getRole());
				
				
				// 상태 정보를 쿠키에 저장하여 전송합니다.
				//Cookie userId = new Cookie("userId", user.getId());
				//response.addCookie(userId);
				
				// 글 목록 화면으로 포워딩합니다.
				RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
				dispatcher.forward(request, response);
				//out.println(user.getName() + "님 로그인 환영!<br>");
				//out.println("<a href='/getBoardList.do'>글 목록 이동</a>");
			} else { // 비밀번호가 틀린 경우
				out.println("비밀번호 오류입니다.<br>");
				out.println("<a href='/'>다시 로그인</a>");
			}
		} else { // 아이디가 틀린 경우
			out.println("아이디 오류입니다.<br>");
			out.println("<a href='/'>다시 로그인</a>");
		}
		
		
		/*
		System.out.println("--------------------Start Line--------------------");
		String method = request.getMethod();
		String url = request.getRequestURI();
		String protocol = request.getProtocol();
		System.out.println(method + " " + url + " " + protocol);
		
		System.out.println("------------------Message Header------------------");
		System.out.println("Host : " + request.getHeader("host"));
		System.out.println("Connection : " + request.getHeader("connection"));
		System.out.println("User-Agent : " + request.getHeader("user-agent"));
		System.out.println("Accept : " + request.getHeader("accept"));
		System.out.println("Accept-Encoding : " + request.getHeader("accept-encoding"));
		System.out.println("Accept-Language : " + request.getHeader("accept-language"));
		*/
		//super.service(req, resp);
		//System.out.println("---> service() 호출");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("===>  GET 방식의 요청 처리");
	//}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println(9/0);
		//System.out.println("===>  POST 방식의 요청 처리");
	//}

	//@Override
	//public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		//System.out.println("---> destroy() 호출");
		
	//}

}
