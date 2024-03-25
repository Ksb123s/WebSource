package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChangeDto {
    private String userid;
    private String password; // 현재
    private String newPassword; // 변경
    private String confirmPassword;// 체크

    public boolean newPasswordEqualsConfirmPassword() {
        return newPassword.equals(confirmPassword);
    }
}
