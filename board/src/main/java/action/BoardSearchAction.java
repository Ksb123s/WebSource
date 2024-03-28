package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.BoardDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardSearchAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        SearchDto Sdto = new SearchDto();
        Sdto.setCriteria(req.getParameter("criteria"));
        Sdto.setKeyword(req.getParameter("keyword"));
        Sdto.setPage(Integer.parseInt(req.getParameter("page")));
        Sdto.setAmount(Integer.parseInt(req.getParameter("amount")));
        // BoardService list 호출
        BoardService service = new BoardServiceImpl();
        List<BoardDto> list = service.list(Sdto);

        // req 결과 담기
        req.setAttribute("list", list);
        req.setAttribute("search", Sdto);

        return new ActionForward(path, false);
    }
}
