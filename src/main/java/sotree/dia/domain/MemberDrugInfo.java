package sotree.dia.domain;

import javax.persistence.*;

@Table(name = "memberDrugInfo")
@Entity
public class MemberDrugInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private Long drugId;
}
