package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookRegisterAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // register.jsp 값 가져오기
        String id = req.getParameter("userid");
        String pwd = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        MemberDto memberDto = new MemberDto(id, pwd, email, name);
        // 서비스 호출
        BookService service = new BookServiceImpl();
        // 결과 값에 따라 성공시 login, 실패시 register
        if (!service.register(memberDto)) {
            path = "/view/register.jsp";
        }

        return new ActionForward(path, false);
    }

}
