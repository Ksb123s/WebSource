package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLeaveAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // userid, password 가져오기
        MemberDto dto = new MemberDto();
        dto.setUserid(req.getParameter("userid"));
        dto.setPassword(req.getParameter("password"));
        HttpSession session = req.getSession();

        // 서비스 호출
        BookService service = new BookServiceImpl();
        // true 로 결과를 받은 정보 seesion 저장
        if (!service.Leave(dto)) {
            path = "/view/leave.jsp";
        } else {
            session.invalidate();
        }
        return new ActionForward(path, false);
    }

}
