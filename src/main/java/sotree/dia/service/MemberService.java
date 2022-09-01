package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sotree.dia.domain.Member;
import sotree.dia.domain.SignupDto;
import sotree.dia.repository.MemberRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    public Optional<Member> findByUsername(String username){
        Optional<Member> find = memberRepository.findByUsername();
        log.info("찾으려는 유저의 이름 : {}, 결과 : {}", username, find);
        return find;
    }
    public Long save(SignupDto signupDto){
        Member member = new Member(signupDto.getUsername(), signupDto.getPassword());
        Member save = memberRepository.save(member);
        log.info("신규 유저 {} 등록 성공", member.getUsername());
        return save.getId();
    }
}
