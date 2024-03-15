<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Response</title>
</head>
<body>
    <% 
    
    // JSP 내장객체
    // 1) HttpServletRequest  request
    // 2) HttpServletResponse  response
    // 3) JSpWriter out
    // 4) PageContext pageContext : jsp페이지에 대한 정보를 저장하고 있는 객체
    //      1. forward()
    //      2. include("포함할 페이지 경로") : ex디자인 템플릿 구성시 사용
    


    // sendREdirect(경로) : 나에게 들어온 요청을 다른 페이지(경로)로 이동
    // response.sendRedirect("/basic/input.html");
    pageContext.forward("content.jsp");
    // 주소는 요청 주소인 상태 
    
    
    %>
</body>
</html>