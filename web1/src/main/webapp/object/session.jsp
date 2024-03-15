<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session</title>
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
    // 5)HttpSession session
    //      세션: 특정 서버와 연결된 상태
    //      https 와 http 프로토콜 특징
    //      -무상태(stateless) <==> 상태(stateful)
    //          클라이언트 상태를 저장하지 않음 
    //      상태 저장 필요하다면
    //      1). 서버 측 - 세션
    //      2). 클라이언트 측 - 쿠키/브라우저에 저장 - 브라우저 마다 벨류 값이 다르게 설정 된다.

    
    
    %>
    <h2>세션 테스트</h2>
    <ul>
        <li>isNew() : <%=session.isNew()%></li>
        <li>생성시간 : <%=session.getCreationTime()%></li>
        <li>최종접속시간 : <%=session.getLastAccessedTime()%></li>
        <li>세션ID : <%=session.getId()%></li>
    </ul>
</body>
</html>