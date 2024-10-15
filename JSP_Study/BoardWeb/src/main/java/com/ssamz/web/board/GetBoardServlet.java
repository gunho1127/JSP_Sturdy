package com.ssamz.web.board;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class GetBoardServlet
 */
@WebServlet("/getBoard.do")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("---> GetBoardServlet -> service() 메소드 호출");
		
		// 0. 상태 정보 체크
		/*
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			response.sendRedirect("/");
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
		// 1. 사용자 입력 정보 추출
		String seq  = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//System.out.println("--> 글 번호 : " + board.getSeq());
		//System.out.println("--> 글 제목 : " + board.getTitle());
		
		// 3. 응답 화면 구성
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>글 상세</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<center>");
		
		out.println("<h1>글 상세</h1>");
		out.println("<a href='logout.do'>Log-out</a></h3>");
		out.println("<hr>");
		
		out.println("<form action='updateBoard.do' method='post'>");
		
		out.println("<input name='seq' type='hidden' value='" + board.getSeq() + "'/>");
		
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		
		// 제목
		out.println("<tr>");
		out.println("<td bgcolor='orange' width='70'>제목</td>");
		out.println("<td align='left'><input name='title' type='text' value='" + 
			board.getTitle() + "'/></td>");
		out.println("</tr>");
		
		// 작성자
		out.println("<tr>");
		out.println("<td bgcolor='orange'>작성자</td>");
		out.println("<td align='left'>" + board.getWriter() + "</td>");
		out.println("</tr>");
		
		// 내용
		out.println("<tr>");
		out.println("<td bgcolor='orange'>내용</td>");
		out.println("<td align='left'><textarea name='content' cols='40' rows='10'>" + board.getContent() + "</textarea></td>");
		out.println("</tr>");
		
		// 등록일
		out.println("<tr>");
		out.println("<td bgcolor='orange'>등록일</td>");
		out.println("<td align='left'>" + board.getRegDate() + "</td>");
		out.println("</tr>");
		
		// 조회수
		out.println("<tr>");
		out.println("<td bgcolor='orange'>조회수</td>");
		out.println("<td align='left'>" + board.getCnt() + "</td>");
		out.println("</tr>");
		
		// 글 수정
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='글 수정'/>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</form>");
		
		// 글 등록 | 글 삭제 | 글 목록
		out.println("<hr>");
		out.println("<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;");
		
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("userRole");
		
		if (userRole.equals("ADMIN")) {
			out.println("<a href='deleteBoard.do?seq=" + board.getSeq() + 
					"'>글삭제</a>&nbsp;&nbsp;&nbsp;");
		}
	
		out.println("<a href='getBoardList.do'>글목록</a>");
		
		out.println("</center>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		out.close();
	}

}








