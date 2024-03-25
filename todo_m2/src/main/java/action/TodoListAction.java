package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoListAction implements Action {

    private String path;

    public TodoListAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        TodoService service = new TodoServiceImpl();
        List<TodoDto> list = service.list();
        req.setAttribute("list", list);

        // false : forward 이동
        return new ActionForward(path, false);
    }

}
