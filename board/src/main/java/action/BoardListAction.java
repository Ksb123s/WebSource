package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.PageDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardListAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = (req.getParameter("criteria"));
        String Keyword = (req.getParameter("keyword"));
        BoardService service = new BoardServiceImpl();
        int count = service.count(criteria, Keyword);

        SearchDto searchDto = new SearchDto(Integer.parseInt(page), Integer.parseInt(amount), criteria, Keyword);

        // BoardService list 호출
        PageDto pageDto = new PageDto(searchDto, count);
        List<BoardDto> list = service.list(searchDto);

        // req 결과 담기
        req.setAttribute("list", list);
        req.setAttribute("pageDto", pageDto);

        return new ActionForward(path, false);
    }
}
