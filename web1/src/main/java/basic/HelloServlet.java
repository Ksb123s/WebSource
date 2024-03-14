package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  HttpServletRequest : 사용자의 요청 가져오는 객체
 *  HttpServletResponse : 사용자에게 응답할 때 사용하는 객체
 *  post 방식의 한글은 깨짐
 * 
*/
@WebServlet("/hello") // Servlet 별칭 (임의 부여 가능)
public class HelloServlet extends HttpServlet {
    @Override
    // input methode 가 get 일시 발생
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // post 방식의 한글은 깨짐

        // post로 넘어오는 한글을 인코딩 처리
        req.setCharacterEncoding("utf-8");

        // 가저오는 모든 데이터는 스트링(String)
        // req.getParameter("form 요소 명");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        // value가 여러개인 checkbox인 값 가져오기
        String[] dogs = req.getParameterValues("dog");

        // 응답 페이지에 대한 setting
        res.setContentType("text/html;charset=utf-8"); // html파일로 응답
        PrintWriter out = res.getWriter(); // out을 얻어와서 tag 작성
        out.print("<ul>");
        out.print("<li> id : " + id + "</li>");
        out.print("<li> name : " + name + "</li>");
        for (String dog : dogs) {
            out.print("<li> dog : " + dog + "</li>");
        }
        out.print("</ul>");

    }

    @Override
    // input methode 가 post 일시 발생
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); // post로 정보가 넘어오면 get으로 다시 전달 하여 코드 간략화
    }
}
