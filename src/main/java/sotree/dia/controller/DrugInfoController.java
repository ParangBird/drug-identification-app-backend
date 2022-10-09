package sotree.dia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.service.DrugInfoService;

@RestController
@RequiredArgsConstructor
public class DrugInfoController {
    private final DrugInfoService drugInfoService;
    @GetMapping("/api/drug/test")
    public DrugInfo helloDrug(){
        DrugInfo drugInfo = drugInfoService.findBy(200300406L);
        return drugInfo;
    }
}
