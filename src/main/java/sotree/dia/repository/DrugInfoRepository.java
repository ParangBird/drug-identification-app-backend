package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sotree.dia.domain.entity.DrugInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugInfoRepository extends JpaRepository<DrugInfo, Long> {
    Optional<DrugInfo> findById(Long id);
    Optional<DrugInfo> findByDrugId(Long id);
    @Query(value = "SELECT d from DrugInfo d WHERE d.drugName LIKE %:drugName%")
    List<DrugInfo> findByDrugNameContains(@Param("drugName") String drugName);
}
