package sotree.dia.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.domain.LoginDto;
import sotree.dia.domain.Member;
import sotree.dia.domain.SignupDto;
import sotree.dia.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/api/login")
    public String login(@ModelAttribute @Validated LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("로그인 폼 입력 에러 {}", error.toString());
            }
            return "no";
        }
        Optional<Member> find = memberService.findByUsername(loginDto.getUsername());
        if(find.isEmpty()){
            return "empty";
        }
        return "ok";
    }

    @PostMapping("/api/signup")
    public String signup(@ModelAttribute @Validated SignupDto signupDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("회원가입 폼 입력 에러 {}", error.toString());
            }
            return "no";
        }
        memberService.save(signupDto);
        return "ok";
    }
}
