package com.ssamz.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;

/**
 * Servlet implementation class GetBoardListServlet
 */
@WebServlet("/getBoardList.do")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("/getBoardList.do");
		
		// 0. 상태 정보 체크
		/*
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			response.sendRedirect("/");
		}
		*/
		
		// 0. 인코딩 설정
		//ServletContext context = request.getServletContext();
		//String encoding = context.getInitParameter("boardEncoding");
		//request.setCharacterEncoding(encoding);
		
		// 1. 사용자 입력 정보 추출
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		// Null Check
		if ( searchCondition == null ) {
			searchCondition = "TITLE";
		}
		
		if ( searchKeyword == null) {
			searchKeyword = "";
		}
		
		// 세션에 검색 관련 정보를 저장합니다.
		HttpSession session = request.getSession();
		session.setAttribute("condition", searchCondition);
		session.setAttribute("keyword", searchKeyword);
		
		// 0. 상태 정보 체크
		/*
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		
		if (session.isNew()) {
			System.out.println("===> 처음 생성된 세션 : " + sessionId);
		} else {
			System.out.println("===> 재사용중인 세션 : " + sessionId);
		}
		*/
		
		// 0. 상태 정보 체크
		/*Cookie[] cookieList = request.getCookies(); 
		
		if (cookieList == null) {
			response.sendRedirect("/login.html");
		} else {
			
			String userId = null;
			
			for (Cookie cookie : cookieList) {
				if (cookie.getName().equals("userId")) {
					userId = cookie.getValue();
				}
			}
			
			if (userId == null) {
				response.sendRedirect("/login.html");
			}
		
		}
		*/
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 응답 화면 구성
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>글 목록</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<center>");
		
		out.println("<h1>게시글 목록</h1>");
		
		String userName = (String) session.getAttribute("userName");
		//String welcomeMessage =  (String) context.getAttribute("welcomeMessage");
		//String welcomeMessage = (String) session.getAttribute("welcomeMessage");
		//String welcomeMessage = (String) request.getAttribute("welcomeMessage");
		//out.println("<h3>" + userName + welcomeMessage);
		out.println("<h3>" + userName + "님 환영합니다......");
		//out.println("<h3>" + userName + "님 로그인 환영합니다......");
		out.println("<a href='logout.do'>Log-out</a></h3>");
		
		out.println("<!-- 검색 시작 -->");
		out.println("<form action='getBoardList.do' method='post'>");
		
		out.println("<table border='1' cellpadding='0' width='700'>");
		
		out.println("<tr>");
		out.println("<td align='right'>");
		
		// 검색 조건
		out.println("<select name='searchCondition'>");
		
		String condition = (String) session.getAttribute("condition");
		
		if (condition.equals("TITLE")) {
			out.println("<option value='TITLE' selected>제목");
		} else {
			out.println("<option value='TITLE'>제목");
		}
		
		if (condition.equals("CONTENT")) {
			out.println("<option value='CONTENT' selected>내용");
		} else {
			out.println("<option value='CONTENT'>내용");
		}
		
		//out.println("<option value='TITLE'>제목");
		//out.println("<option value='CONTENT'>내용");
		out.println("</select>");

		// 검색어
		out.println("<input name='searchKeyword' type='text' value='" 
					+ session.getAttribute("keyword") + "'/>");
		//out.println("<input name='searchKeyword' type='text' />");
		
		// 검색 버튼
		out.println("<input type='submit' value='검색'/>");
		
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</form>");
		out.println("<!-- 검색 종료 -->");
		
		
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		
		// 셀 제목
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>번호</th>");
		out.println("<th bgcolor='orange' width='200'>제목</th>");
		out.println("<th bgcolor='orange' width='150'>작성자</th>");
		out.println("<th bgcolor='orange' width='150'>등록일</th>");
		out.println("<th bgcolor='orange' width='100'>조회수</th>");
		out.println("</tr>");
		
		// 셀 내용
		for (BoardVO board : boardList) {
			out.println("<tr>");
			out.println("<td>" + board.getSeq() + "</td>");
			out.println("<td align='left'><a href='getBoard.do?seq="+ board.getSeq() +"'>" + board.getTitle() + "</a></td>");
			out.println("<td>" + board.getWriter() + "</td>");
			out.println("<td>" + board.getRegDate() + "</td>");
			out.println("<td>" + board.getCnt() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("<br>");
		out.println("<a href='insertBoard.html'>새글 등록</a>");
		
		out.println("</center>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		out.close();
		
		/*
		// 2. 응답 화면 구성
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>게시글 목록</h1>");
		out.println("<hr>");
		
		for (BoardVO board : boardList) {
			out.println("---> " + board.toString() + "<br>");
		}
		
		out.close();
		*/
	
	}

}
