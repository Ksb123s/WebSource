<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="DAO.ToDoDao" %>
<%@ page import="DTO.ToDoDto" %>
<%@ page import="java.util.List" %>
<%
    request.setCharacterEncoding("utf-8");  
    // 사용자가 작성한 코드 입력
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    // DB 작업
    //1. DB드라이버 연결
    ToDoDao dao = new ToDoDao();

    ToDoDto insertDto = new ToDoDto();
    insertDto.setTitle(title);
    insertDto.setDescription(description);

    int result = dao.insert(insertDto);



    // 화면이동(List)
    response.sendRedirect("list.jsp");

%>