package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sotree.dia.domain.entity.Member;
import sotree.dia.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> findByUsername(String username) {
        Optional<Member> find = memberRepository.findByUsername(username);
        log.info("찾으려는 유저의 이름 : {}, 결과 : {}", username, find);
        return find;
    }

    public List<Member> findAllByName(String name) {
        List<Member> find = memberRepository.findAllByName(name);
        if (find == null || find.isEmpty())
            return null;
        return find;
    }

    public Long save(Member newMember) {
        Member save = memberRepository.save(newMember);
        log.info("유저 {} 등록 성공", newMember.getUsername());
        return save.getId();
    }

    public Optional<Member> findById(Long id) {
        Optional<Member> find = memberRepository.findById(id);
        if (find == null || find.isEmpty())
            return null;
        return find;
    }
}
