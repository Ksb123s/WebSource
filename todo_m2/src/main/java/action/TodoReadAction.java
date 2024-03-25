package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoReadAction implements Action {

    private String path;

    public TodoReadAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // TodoReadServlet 에서 했던 작업
        String no = req.getParameter("no");

        TodoService service = new TodoServiceImpl();
        TodoDto todo = service.getRow(no);

        req.setAttribute("todo", todo);

        return new ActionForward(path, false);
    }

}
