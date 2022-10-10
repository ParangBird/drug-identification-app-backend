package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sotree.dia.domain.dto.AddDrugDto;
import sotree.dia.domain.entity.MemberDrugInfo;
import sotree.dia.repository.MemberDrugInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberDrugInfoService {
    private final MemberDrugInfoRepository memberDrugInfoRepository;
    public MemberDrugInfo save(MemberDrugInfo newMemberDrugInfo){
        MemberDrugInfo save = memberDrugInfoRepository.save(newMemberDrugInfo);
        return save;
    }
    public List<MemberDrugInfo> findAllByMemberId(Long id){
        return memberDrugInfoRepository.findAllByMemberId(id);
    }
    public void deleteByMemberIdAndDrugId(Long memberId, Long drugId){
        memberDrugInfoRepository.deleteByMemberIdAndDrugId(memberId, drugId);
    }
}
