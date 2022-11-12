package sotree.dia.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "drug_shape")
@Entity
@Getter
@RequiredArgsConstructor
public class DrugShape {
    @Id
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "drug_letter_front")
    private String drugLetterFront;
    @Column(name = "drug_letter_back")
    private String drugLetterBack;
    @Column(name = "drug_form")
    private String drugForm;
    @Column(name = "drug_color")
    private String drugColor;
}
