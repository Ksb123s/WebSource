<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h3 class="border-bottom mb-3">도서목록</h3>
<table class="table table-bordered">
  <thead>
    <tr class="table-success">
      <th scope="col" class ="text-center">번호</th>
      <th scope="col" class ="text-center">제목</th>
      <th scope="col" class ="text-center">저자</th>
      <th scope="col" class ="text-center">가격</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="list" items="${list}">
    <tr>
      <th scope="row" class ="text-center">${list.code}</th>
      <td > <a href='<c:url value="/read?code=${list.code}"/>'class="text-decoration-none text-reset">${list.title}</a></td>
      <td class ="text-center">${list.writer}</td>
      <td class ="text-end"> 
      <fmt:formatNumber type="number" maxFractionDigits="3" value="${list.price}" />
        </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
<%@ include file="../include/section.jsp"%>
<%@ include file="../include/footer.jsp"%>  