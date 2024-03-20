<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/header.jsp"%>
<h1 class="mt-5">Todo List</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="dto" items="${list}">
    <tr>
      <th scope="row">${dto.no}</th>
      <td><a class="text-decoration-none text-reset" href='<c:url value="/read?no=${dto.no}"/>'>${dto.title}</a></td>
      <td>${dto.createdAt}</td>
      <td>
        <input type="checkbox" class="form-check-input" id="completed" placeholder="completed" name="completed" value="true" onClick="return false" <c:out value="${dto.completed ? 'checked':''}"/>
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
<%@ include file="../include/footer.jsp"%>



