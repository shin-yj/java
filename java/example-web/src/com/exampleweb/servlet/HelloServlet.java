package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Httpservlet을 상속하는 것은 : Servlet Class가 구현해야 할 인터페이스를 자동으로 구현하는 것
public class HelloServlet extends HttpServlet {
	
	// Get방식의 요청이 발생했을 때 호출되는 약속된 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 네트워크를 통해서 텍스트 데이터를 출력하는 객체
		PrintWriter writer = resp.getWriter(); // writer -> io와 관련된 데이터. 텍스트 데이터 출력
		//클라이언트(브라우저)에 데이터 전송
		writer.println("Hello, Servlet !!!");
		writer.println(new Date().toString());
	}
	
	// Post방식의 요청이 발생했을 때 호출되는 약속된 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}

}
