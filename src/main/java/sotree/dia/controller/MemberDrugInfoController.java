package sotree.dia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sotree.dia.domain.dto.AddDrugDto;
import sotree.dia.domain.dto.DeleteDrugDto;
import sotree.dia.domain.entity.MemberDrugInfo;
import sotree.dia.service.DrugInfoService;
import sotree.dia.service.MemberDrugInfoService;
import sotree.dia.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberDrugInfoController {
    private final MemberDrugInfoService memberDrugInfoService;
    private final DrugInfoService drugInfoService;
    private final MemberService memberService;
    @PostMapping("/api/memberDrug/add")
    public String memberAddDrug(@ModelAttribute AddDrugDto addDrugDto){
        Long memberId = addDrugDto.getMemberId();
        Long drugId = addDrugDto.getDrugId();
        if(drugInfoService.findByDrugId(drugId) == null){
            return "해당하는 약이 없어요";
        }
        if(memberService.findById(memberId) == null){
            return "해당하는 멤버가 없어요";
        }
        List<MemberDrugInfo> memberDrugInfoList = memberDrugInfoService.findAllByMemberId(addDrugDto.getMemberId());
        for(MemberDrugInfo info : memberDrugInfoList){
            System.out.println("info.getDrugId() = " + info.getDrugId());
            if(info.getDrugId().equals(addDrugDto.getDrugId())){
                return "이미 있어요";
            }
        }
        MemberDrugInfo newMemberDrugInfo = new MemberDrugInfo(addDrugDto.getMemberId(), addDrugDto.getDrugId());
        memberDrugInfoService.save(newMemberDrugInfo);
        return "OK";
    }

    @GetMapping("/api/memberDrug/list")
    public List<MemberDrugInfo> getMemberDrugList(@RequestParam Long memberId){
        return memberDrugInfoService.findAllByMemberId(memberId);
    }

    @PostMapping("/api/memberDrug/delete")
    public String deleteMemberDrug(@ModelAttribute DeleteDrugDto deleteDrugDto){
        Long memberId = deleteDrugDto.getMemberId();
        Long drugId = deleteDrugDto.getDrugId();
        if(drugInfoService.findByDrugId(drugId) == null){
            return "해당하는 약이 없어요";
        }
        if(memberService.findById(memberId) == null){
            return "해당하는 멤버가 없어요";
        }
        List<MemberDrugInfo> memberDrugInfoList = memberDrugInfoService.findAllByMemberId(deleteDrugDto.getMemberId());
        for(MemberDrugInfo info : memberDrugInfoList){
            if(info.getDrugId().equals(deleteDrugDto.getDrugId())){
                memberDrugInfoService.deleteByMemberIdAndDrugId(memberId, drugId);
                return "ok";
            }
        }
        return "해당하는 정보 없어요";
    }
}
