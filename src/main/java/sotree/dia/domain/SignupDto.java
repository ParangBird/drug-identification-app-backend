package sotree.dia.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class SignupDto {
    @NotBlank(message = "아이디를 입력해 주세요")
    @Max(value = 10, message = "아이디는 최대 10자 입니다.") @Min(value = 5, message = "아이디는 최소 5자 입니다")
    private String username;
    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Max(value = 20, message = "비밀번호는 최대 20자 입니다") @Min(value = 5,message = "비밀번호는 최소 5자 입니다")
    private String password;
}