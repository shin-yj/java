<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!-- 재사용할 내용  -->
		<div id="header" style='background-color:palegreen'>    	
            <div class="title">
                <a href="/demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% String user = (String)session.getAttribute("loginuser"); %> <!-- 로그인 되었는지 세션에서 확인 -->
            <% if (user == null) { %>
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
            <% } else { %>
            	<%= user %>님 환영합니다.
            	<a href="/demoweb/account/login.action">로그아웃</a>
            <% } %>
            
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>