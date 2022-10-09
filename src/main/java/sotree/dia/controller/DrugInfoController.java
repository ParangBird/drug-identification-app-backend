package sotree.dia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.service.DrugInfoService;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrugInfoController {
    private final DrugInfoService drugInfoService;
    @GetMapping("/api/drug/test")
    public DrugInfo helloDrug(){
        DrugInfo drugInfo = drugInfoService.findByDrugId(200300406L);
        return drugInfo;
    }
    @GetMapping("/api/drug/textSearch")
    public List<DrugInfo> textSearch(@RequestParam String drugName){
        List<DrugInfo> drugInfos = drugInfoService.findByDrugNameContains(drugName);
        return drugInfos;
    }
}
