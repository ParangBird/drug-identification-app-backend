package sotree.dia.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Table(name = "drug_info")
@Entity
@Getter
@RequiredArgsConstructor
public class DrugInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "drug_company")
    private String drugCompany;
    @Column(name = "drug_ingredient")
    private String drugIngredient;
    @Column(name = "drug_effect")
    private String drugEffect;
    @Column(name = "drug_howtouse")
    private String drugHowToUse;
    @Column(name = "drug_mustknow")
    private String drugMustKnow;
    @Column(name = "drug_caution")
    private String drugCaution;
    @Column(name = "drug_interaction")
    private String drugInteraction;
    @Column(name = "drug_sideeffect")
    private String drugSideEffect;
    @Column(name = "drug_storage")
    private String drugStorage;
}
