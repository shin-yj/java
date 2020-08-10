package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/home.action"}) // 서버코드, 서버는 애플리케이션에 이미 돌아가고 있으므로 서버에서 경로 표현할 때 애플리케이션 이름 쓰지 않는다.
public class HomeServlet extends HttpServlet { // sevlet과 연결 // get방식 // home.action에 요청이 들어오면 homesevlet으로 요청 들어온당
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 요청 처리(여기서는 특별히 할 것이 없음)
		
			// JSP로 forward 이동해서 응답 컨텐츠 생산 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home.jsp"); // 요청을 전달하는 것 찾기
		dispatcher.forward(req, resp);
		

	}

}


