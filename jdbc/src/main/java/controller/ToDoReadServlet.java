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

@WebServlet("/read")
public class ToDoReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB연동
        req.setCharacterEncoding("utf-8");
        // 사용자가 작성한 코드 입력: 제목 클릭시 no 값 가져오기
        String no = req.getParameter("no");
        // DB 작업
        ToDoDao dao = new ToDoDao();
        ToDoDto todo = dao.getRow(no);

        // getRowDto를 read.jsp에 표출
        req.setAttribute("todo", todo);
        RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
