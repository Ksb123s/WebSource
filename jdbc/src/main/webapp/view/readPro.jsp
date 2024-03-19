<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="DAO.ToDoDao" %>
<%@ page import="DTO.ToDoDto" %>
<%@ page import="java.util.List" %>
<%
    request.setCharacterEncoding("utf-8");  
    // 사용자가 작성한 코드 입력: 제목 클릭시 no  값 가져오기
    String no = request.getParameter("no");
    // DB 작업
    ToDoDao dao = new ToDoDao();
    ToDoDto todo =  dao.getRow(no);

    // getRowDto를 read.jsp에 표출
    request.setAttribute("todo", todo);
    
    // 화면이동(List)
    pageContext.forward("read.jsp");

%>