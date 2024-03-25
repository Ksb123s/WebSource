package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLoginAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // userid, password 가져오기
        MemberDto dto = new MemberDto();
        dto.setUserid(req.getParameter("userid"));
        dto.setPassword(req.getParameter("password"));

        // 서비스 호출
        BookService service = new BookServiceImpl();
        MemberDto dto2 = service.login(dto);
        // true 로 결과를 받은 정보 seesion 저장
        if (dto2 != null) {
            HttpSession session = req.getSession();
            session.setAttribute("dto2", dto2);
        } else {
            path = "/view/login.jsp";
        }
        return new ActionForward(path, false);
    }

}
