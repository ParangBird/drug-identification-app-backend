package sotree.dia.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "memberDrugInfo")
@Getter
@Entity
public class MemberDrugInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private Long drugId;
    public MemberDrugInfo(Long memberId, Long drugId){
        this.memberId = memberId;
        this.drugId = drugId;
    }

    public MemberDrugInfo() {

    }
}
