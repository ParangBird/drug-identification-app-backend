package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sotree.dia.domain.entity.MemberDrugInfo;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberDrugInfoRepository extends JpaRepository<MemberDrugInfo, Long> {
    List<MemberDrugInfo> findAllByMemberId(Long id);
    @Modifying
    @Transactional
    @Query("DELETE from MemberDrugInfo WHERE memberId = :memberId and drugId = :drugId")
    void deleteByMemberIdAndDrugId(@Param("memberId") Long memberId, @Param("drugId") Long drugId);
}
