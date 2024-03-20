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

@WebServlet("/create")
public class BookCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String code = req.getParameter("code");
        String writer = req.getParameter("writer");
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        BookDao dao = new BookDao();
        BookDto insertdto = new BookDto();

        insertdto.setCode(Integer.parseInt(code));
        insertdto.setWriter(writer);
        insertdto.setTitle(title);
        insertdto.setPrice(Integer.parseInt(price));
        insertdto.setDescription(description);

        int result = dao.insert(insertdto);

        if (result > 0) {
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("/view/create.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
