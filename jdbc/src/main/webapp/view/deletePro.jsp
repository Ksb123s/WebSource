<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="DAO.ToDoDao" %>
<%@ page import="DTO.ToDoDto" %>
<%@ page import="java.util.List" %>
<%
    request.setCharacterEncoding("utf-8");  
    // 사용자가 작성한 코드 입력: 제목 클릭시 no  값 가져오기
    // value 가 없는 경우 checkboc, radio 경우  on ,off 방식
    String no = request.getParameter("no");

    // DB 작업
    ToDoDao dao = new ToDoDao();
    
    // getRowDto를 read.jsp에 표출
    int result = dao.delete(no);
    
    // 화면이동(List)
    // pageContext.forward("list.jsp");
    response.sendRedirect("list.jsp");

%>