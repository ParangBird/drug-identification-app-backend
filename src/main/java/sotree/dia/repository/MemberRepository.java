package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sotree.dia.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
