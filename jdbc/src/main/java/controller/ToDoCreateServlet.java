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

@WebServlet("/create")
public class ToDoCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 사용자가 작성한 코드 입력
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        // DB 작업
        // 1. DB드라이버 연결
        ToDoDao dao = new ToDoDao();

        ToDoDto insertDto = new ToDoDto();
        insertDto.setTitle(title);
        insertDto.setDescription(description);

        int result = dao.insert(insertDto);

        // 화면이동(List)
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
