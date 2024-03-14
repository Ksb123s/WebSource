package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2") // 마음대로지만 중복 x
public class AddServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 사용자 입력 값 가져오기
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        String op = req.getParameter("op");
        // 사칙 연산 화면 출력
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        int result = 0;
        switch (op) {
            case "+":
                result = (num1 + num2);
                break;
            case "-":
                result = (num1 - num2);
                break;
            case "*":
                result = (num1 * num2);
                break;
            case "/":
                result = (num1 / num2);
                break;

            default:
                break;
        }
        out.print(num1 + op + num2 + " = " + result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
