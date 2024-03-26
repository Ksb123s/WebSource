package action;

import java.io.File;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
@MultipartConfig
public class BoardWriteAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String password = req.getParameter("password");
        BoardDto dto = new BoardDto();
        // 파일 업로드 처리
        Part part = req.getPart("attach");
        String fileName = getFileName(part);

        String dir = "C:\\Upload";

        if (!fileName.isEmpty()) {
            // 중복 파일명은 저장을 해주지 않음 => 서버에 저장 시 다른 이름 사용
            // 고유한 값 생성 => 고유한값_사용자가 올린 파일명
            UUID uuid = UUID.randomUUID();
            File uploadFile = new File(dir + File.separator + uuid + "_" + fileName);
            part.write(uploadFile.toString());
            dto.setAttach(uploadFile.getName());

        }

        System.out.println(dto);
        dto.setName(name);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setPassword(password);

        BoardService service = new BoardServiceImpl();

        if (!service.insert(dto)) {
            path = "/view/qna_board_write.jsp";
        }
        return new ActionForward(path, true);
    }

    private String getFileName(Part part) {
        // Content-Disposition: attachment; filename="filename.jpg"
        String header = part.getHeader("content-disposition");
        String[] arr = header.split(";");
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
            }
        }
        return "";
    }
}
