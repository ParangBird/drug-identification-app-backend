package sotree.dia.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.domain.*;
import sotree.dia.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/login")
    public Object login(@ModelAttribute @Validated LoginDto loginDto, BindingResult bindingResult){
        log.info("로그인 시도 : {} {}", loginDto.getUsername(), loginDto.getPassword());
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("로그인 폼 입력 에러 {}", error.toString());
            }
            return allErrors.get(0).getDefaultMessage();
        }
        Optional<Member> find = memberService.findByUsername(loginDto.getUsername());
        if(find.isEmpty()){
            return "회원 정보가 비정확합니다.";
        }
        if(!find.get().getPassword().equals(loginDto.getPassword())){
            return "회원 정보가 비정확합니다.";
        }
        return find.get();
    }

    @PostMapping("/api/signup")
    public String signup(@ModelAttribute @Validated SignupDto signupDto, BindingResult bindingResult){
        if(!signupDto.getPassword().equals(signupDto.getPasswordCheck())){
            return "비밀번호를 재확인해주세요";
        }
        if(memberService.findByUsername(signupDto.getUsername()).isPresent()){
            return "이미 존재하는 아이디입니다.";
        }
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("회원가입 폼 입력 에러 {}", error.toString());
            }
            return allErrors.get(0).getDefaultMessage();
        }
        memberService.save(signupDto);
        return "회원가입 성공";
    }

    @PostMapping("/api/findId")
    public String findId(@ModelAttribute @Validated FindIdDto findIdDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("아이디 찾기 폼 입력 에러 {}", error.toString());
            }
            return allErrors.get(0).getDefaultMessage();
        }
        List<Member> sameNames = memberService.findAllByName(findIdDto.getName());
        if(sameNames == null || sameNames.isEmpty()){
            return "회원 정보가 비정확합니다.";
        }
        for (Member sameName : sameNames) {
            if(findIdDto.getPersonalNumber().equals(sameName.getPersonalNumber()))
                return "아이디 : " + sameName.getUsername();
        }
        return "회원 정보가 비정확합니다.";
    }

    @PostMapping("/api/findPw")
    public String findPw(@ModelAttribute @Validated FindPwDto findPwDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("비밀번호 찾기 폼 입력 에러 {}", error.toString());
            }
            return allErrors.get(0).getDefaultMessage();
        }
        Optional<Member> find = memberService.findByUsername(findPwDto.getUsername());
        if(find == null || find.isEmpty()){
            return "회원 정보가 비정확합니다.";
        }
        return "비밀 번호 : " + find.get().getPassword();
    }

}
