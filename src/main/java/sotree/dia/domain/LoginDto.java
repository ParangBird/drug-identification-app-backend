package sotree.dia.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotBlank (message = "아이디를 입력해 주세요")
    private String username;
    @NotBlank (message = "비밀번호를 입력해 주세요")
    private String password;
}