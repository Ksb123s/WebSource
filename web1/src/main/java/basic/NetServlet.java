package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/net")
public class NetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // HttpServletRequest 객체로 알수있는 정보
        // 1. 사용자 입력 가져오기
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.print("Request Scheme : " + req.getScheme() + "<br>");
        out.print("Server Name : " + req.getServerName() + "<br>");
        out.print("Server Addr : " + req.getLocalAddr() + "<br>");
        out.print("Server Post : " + req.getServerPort() + "<br>");
        out.print("Child Addr : " + req.getRemoteAddr() + "<br>");
        out.print("Child Host : " + req.getRemoteHost() + "<br>");
        out.print("Child Port : " + req.getRemotePort() + "<br>");
        out.print("Request URI : " + req.getRequestURI() + "<br>");
        out.print("Request URL : " + req.getRequestURL() + "<br>");
        out.print("ContentPath : " + req.getContextPath() + "<br>");
        out.print("ServletPath : " + req.getServletPath() + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
