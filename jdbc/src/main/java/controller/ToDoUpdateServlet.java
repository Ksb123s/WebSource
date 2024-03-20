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

@WebServlet("/update")
public class ToDoUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // DB연동
        String completed = req.getParameter("completed");
        String description = req.getParameter("description");
        String no = req.getParameter("no");

        // DB 작업
        ToDoDao dao = new ToDoDao();
        ToDoDto updateDto = new ToDoDto();

        updateDto.setCompleted(Boolean.parseBoolean(completed));
        updateDto.setDescription(description);
        updateDto.setNo(Integer.parseInt(no));

        // getRowDto를 read.jsp에 표출
        int result = dao.update(updateDto);

        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
