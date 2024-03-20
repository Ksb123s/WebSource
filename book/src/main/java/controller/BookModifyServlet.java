package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDto;

@WebServlet("/modify")
public class BookModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // Integer.parseInt("") => NumberFormException 발생
        int code = Integer.parseInt(req.getParameter("code"));
        int price = Integer.parseInt(req.getParameter("price"));

        BookDao dao = new BookDao();
        BookDto updateDto = new BookDto();
        updateDto.setCode(code);
        updateDto.setPrice(price);

        int result = dao.update(updateDto);

        if (result > 0) {
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("/view/modify.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
