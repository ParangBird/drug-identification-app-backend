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
    @GetMapping("/api/drug/nameSearch")
    public List<DrugInfo> nameSearch(@RequestParam String query){
        List<DrugInfo> drugInfos = drugInfoService.findByDrugNameContains(query);
        return drugInfos;
    }
    @GetMapping("/api/drug/ingredientSearch")
    public List<DrugInfo> ingredientSearch(@RequestParam String query){
        List<DrugInfo> drugInfos = drugInfoService.findByDrugIngredientContains(query);
        return drugInfos;
    }
    @GetMapping("/api/drug/textSearch")
    public List<DrugInfo> textSearch(@RequestParam String query){
        List<DrugInfo> drugInfos = drugInfoService.findByDrugNameAndDrugIngredientContains(query);
        return drugInfos;
    }
}
