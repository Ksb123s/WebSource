package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToDoDao;
import DTO.ToDoDto;

@WebServlet("/delete")
public class ToDoDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        // 사용자가 작성한 코드 입력: 제목 클릭시 no 값 가져오기
        // value 가 없는 경우 checkboc, radio 경우 on ,off 방식
        String no = req.getParameter("no");

        // DB 작업
        ToDoDao dao = new ToDoDao();

        // getRowDto를 read.jsp에 표출
        int result = dao.delete(no);

        // 화면이동(List)
        // pageContext.forward("list.jsp");
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
