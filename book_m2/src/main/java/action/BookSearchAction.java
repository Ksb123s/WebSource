package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookSearchAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // search.jsp 넘긴 값 가져오기
        String creteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        BookService service = new BookServiceImpl();
        List<BookDto> list = service.searhListAll(creteria, keyword);

        req.setAttribute("list", list);

        return new ActionForward(path, false);
    }

}
