package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sotree.dia.domain.entity.DrugInfo;

import java.util.Optional;

@Repository
public interface DrugInfoRepository extends JpaRepository<DrugInfo, Long> {
    Optional<DrugInfo> findByDrugId(Long id);
}
