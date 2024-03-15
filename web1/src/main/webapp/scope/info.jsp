<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<% 
    request.setCharacterEncoding("utf-8");
    String Id = request.getParameter("id");
    String Name = request.getParameter("name");
    String Age = request.getParameter("age");
    //    HttpServletRequest : 유효범위 
    //    request.getParameter() : 사용자의 입력값을 가지고 올 때 범위가 제한 됨
    //    form action 값으로 사용된 페이지까지만 가능 

    //info.jsp 가 알고 있는 값(사용자입력값, db값)을 다른 페이지랑 공유
    // 1).get/post 방식으로 넘겨준다.
    // 2).scope 이용 유효 범위가 나눠져있음
    //      (1).page
    //      (2).request
    //      (3).session
    //      (4).application
%>
<h3>id : <%=Id %></h3>
<h3>name : <%=Name %></h3>
<h3>Age : <%=Age %></h3>
    <%-- <form action="next.jsp" method="post">
      <div>
        <label for="id">id</label>
        <input type="text" name="id" id="id"value="<%=Id %>" readonly/>
      </div>
      <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name"value="<%=Name %>"  readonly/>
      </div>
      <div>
        <label for="age">age</label>
        <input type="text" name="age" id="age"value="<%=Age %>" readonly/>
      </div>
      <div>
        <button type="submit">전송</button>
      </div>
    </form> --%>

