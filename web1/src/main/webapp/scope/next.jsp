<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<% //javacode
   
    request.setCharacterEncoding("utf-8");

    String Id = request.getParameter("id");
    String Name = request.getParameter("name");
    String Age = request.getParameter("age");


%>

<h3>id : <%=Id %></h3>
<h3>name : <%=Name %></h3>
<h3>Age : <%=Age %></h3>
