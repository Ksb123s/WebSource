<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%@ include file="../include/header.jsp"%>
<%@ page import ="DTO.ToDoDto"%>
<%
//    ToDoDto todo = (ToDoDto)request.getAttribute("todo");
%>
<h1 class="mt-5">Todo View</h1>
<form action="" method="post">
    <div class="mb-3">
        <label for="title" class="form-label">title</label>
        <%-- <input type="text" class="form-control" id="title" placeholder="title" name="title" value="<%=todo.getTitle()%>"> --%>
        <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${todo.title}" readonly>
    </div>
    <div class="mb-3">
        <label for="createdAt" class="form-label">createdAt</label>
        <%-- <input type="text" class="form-control" id="createdAt" placeholder="createdAt" name="createdAt" value= "<%=todo.getCreatedAt()%>"> --%>
        <input type="text" class="form-control" id="createdAt" placeholder="createdAt" name="createdAt" value= "${todo.createdAt}" readonly>

    </div>
    <div class="mb-3">
        <label for="completed" class="form-check-label">completed</label>
        <%-- completed 가 true => check ,false => unchecked --%>
        <input type="checkbox" class="form-check-input" id="completed" placeholder="completed" name="completed"  onClick="return false" <c:out value="${todo.completed ? 'checked':''}"/>>
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">description</label>
        <%-- <textarea class="form-control" id="description" name="description" rows="3"><%=todo.getDescription()%></textarea> --%>
        <textarea class="form-control" id="description" name="description" rows="3" readonly>${todo.description}</textarea>
    </div>
    <div>
        <a href='<c:url value="/modify?no=${todo.no}"/>' class="btn btn-primary">수정</a>
        <a class="btn btn-success" href='<c:url value="/list"/>'>목록</a>
    </div>
</form>
<%@ include file="../include/footer.jsp"%>