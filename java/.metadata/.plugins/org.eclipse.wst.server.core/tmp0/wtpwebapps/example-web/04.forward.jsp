<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<%
// 04.result.jsp에서 읽을수 있도록 request 객체에 데이터 저장 // forward의 경우 두 처리기가 데이터 교환, 저장 가능
// 데이터 공유 가능
request.setAttribute("forward", "Data from forward.jsp");
	//04.result.jsp 처리기로 forward 이동
	pageContext.forward("04.result.jsp");

%>
