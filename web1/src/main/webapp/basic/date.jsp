<%@page import="java.util.Date"  %>
<%@page import="java.time.LocalTime"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>현재 시간</h1>
<%-- 
    시간 출력법
    1.script
    2.java
 --%>
    <%
        Date date = new Date();
        out.println(date +"<br>");

    LocalTime corrTime = LocalTime.now();
    out.println(corrTime);
    
    %>
</body>
</html>