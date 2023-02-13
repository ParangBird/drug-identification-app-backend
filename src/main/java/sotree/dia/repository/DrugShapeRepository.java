package sotree.dia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sotree.dia.domain.entity.DrugShape;

import java.util.List;

@RepositoryRestResource
public interface DrugShapeRepository extends JpaRepository<DrugShape, Long> {

    @Query(value = "SELECT d.drugId from DrugShape d WHERE d.drugForm LIKE %:form% AND d.drugColor LIKE %:color% " +
            "AND (d.drugLetterFront like :letter OR d.drugLetterBack like :letter)")
    List<Long> findAllByDrugShape(@Param("letter") String letter,
                                  @Param("form") String form,
                                  @Param("color") String color);

}
