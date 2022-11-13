package sotree.dia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.service.DrugShapeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrugShapeController {
    private final DrugShapeService drugShapeService;

    @GetMapping("/api/shape/search")
    public List<Long> searchDrugShape(@RequestParam(value = "letter", required = false) String letter,
                                           @RequestParam(value = "form", required = false) String form,
                                           @RequestParam(value = "color",required = false) String color) {
        List<Long> drugByShape = drugShapeService.findDrugByShape(letter, form, color);
        return drugByShape;
    }
}
