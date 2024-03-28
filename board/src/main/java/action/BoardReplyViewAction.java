package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReplyViewAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        // BoardService 호출
        BoardService service = new BoardServiceImpl();
        BoardDto dto = service.read(bno);

        // req 결과 담기
        req.setAttribute("dto", dto);

        return new ActionForward(path, false);
    }
}
