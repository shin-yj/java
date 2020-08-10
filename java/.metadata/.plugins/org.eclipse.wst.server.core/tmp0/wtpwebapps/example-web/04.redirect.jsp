<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%


//request 객체에 데이터 저장(redirect 목적지인 result.jsp에서 데이터 읽을 수 없음(request 특성땜에))
// forward는 되지만 redirect는 불가능
request.setAttribute("redirect", "Data from redirect.jsp");
// 04.result.jsp 처리기로 redirect 이동
response.sendRedirect("04.result.jsp");
	
%>