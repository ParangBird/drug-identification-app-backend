package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sotree.dia.domain.entity.Member;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    List<Member> findAllByName(String name);
}
