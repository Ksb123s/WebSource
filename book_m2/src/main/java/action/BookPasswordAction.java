package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.ChangeDto;
import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookPasswordAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // pwd change 에서 넘긴 값 가져오기
        HttpSession session = req.getSession();
        // 기존 정보 가저오기
        MemberDto dto = (MemberDto) session.getAttribute("dto2");

        // 입력 정보 가저오기
        String pwd = req.getParameter("password");
        String conPwd = req.getParameter("confirm-password");
        String newPwd = req.getParameter("new-password");
        // 입력 정보 + 기존정보 저장
        ChangeDto changeDto = new ChangeDto();
        changeDto.setUserid(dto.getUserid());
        changeDto.setPassword(pwd);
        changeDto.setNewPassword(newPwd);
        changeDto.setConfirmPassword(conPwd);
        // 바꿀 비번과 확인비번 체크
        if (changeDto.newPasswordEqualsConfirmPassword()) {
            // 아이디와 현재 비밀번호를 가지고 확인
            MemberDto input = new MemberDto();
            input.setPassword(pwd);
            input.setUserid(dto.getUserid());

            BookService service = new BookServiceImpl();
            if (service.login(input) == null) { // 현재 비번이 틀림

                path = "/view/pwdChange.jsp";
            } else {
                // 사용자가 존재한다면 비밀번호 변경 서비스 메소드 호출

                if (service.pwdChange(changeDto)) {
                    // 변경 완료 여부에 따라 true 면 세션제거 후 로그인 페이지 이동
                    session.invalidate();
                } else {
                    // false 면 pwdchange 이동
                    System.out.println("비번 변경하지 못했습니다.");
                    path = "/view/pwdChange.jsp";
                }
            }
        }

        return new ActionForward(path, false);
    }

}
