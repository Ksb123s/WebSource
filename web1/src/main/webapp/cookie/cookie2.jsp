<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%

/*
 * 쿠키
 * 클라이언트에 보관, 쿠키 유호 및 만료기간 설정,요청이 들어올때 쿠키를 가져올수 있음
 * 
 * 쿠키에 저장
 * 
*/
    Cookie c = new Cookie("name", "Hong");
    c.setMaxAge(600);
    response.addCookie(c);


%>
<h3>쿠키 데이터 저장</h3>
<a href="getCookie2.jsp">쿠키 확인</a>