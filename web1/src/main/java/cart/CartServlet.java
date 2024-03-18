package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCart")
// dasfasd5343848

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 처리
        req.setCharacterEncoding("utf-8");
        // 사용자가 선택한 값 가져오기

        String product = req.getParameter("product");
        // 세션 담기
        // 장바구니 세션 여부 확인
        // ProductDTO dto = new ProductDTO(product);
        HttpSession session = req.getSession();
        ArrayList<String> products = (ArrayList<String>) session.getAttribute("products");

        if (products == null) {
            // 장바구니 세션 생성
            products = new ArrayList<String>();
            products.add(product);
            session.setAttribute("products", products);
        } else {
            // 장바구니 세션이 존재한다면 제품만 추가
            products.add(product);
        }
        // session.setAttribute("product", product);
        // 페이지 이동
        resp.sendRedirect("/cart/basket.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}