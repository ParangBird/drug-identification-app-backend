package sotree.dia.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.exception.NoSuchDrugIdException;
import sotree.dia.service.DrugInfoService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrugInfoController {
    private final DrugInfoService drugInfoService;

    @GetMapping("/api/drug")
    public Object searchDrugInfo(@RequestParam Long query) {
        DrugInfo drugInfo = drugInfoService.findByDrugId(query);
        if (drugInfo == null) {
            return "https://nedrug.mfds.go.kr/pbp/CCBBB01/getItemDetail?itemSeq=" + query;
        }
        return (DrugInfo) drugInfo;
    }

    @GetMapping("/api/drug/nameSearch")
    public List<DrugInfo> nameSearch(@RequestParam String query) {
        List<DrugInfo> drugInfos = drugInfoService.findByDrugNameContains(query);
        return drugInfos;
    }

    @GetMapping("/api/drug/ingredientSearch")
    public List<DrugInfo> ingredientSearch(@RequestParam String query) {
        List<DrugInfo> drugInfos = drugInfoService.findByDrugIngredientContains(query);
        return drugInfos;
    }

    @GetMapping("/api/drug/textSearch")
    public List<DrugInfo> textSearch(@RequestParam String query) {
        List<DrugInfo> drugInfos = drugInfoService.findByDrugNameAndDrugIngredientContains(query);
        return drugInfos;
    }

    @GetMapping(value = "/api/image/{drugId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] drugImage(@PathVariable("drugId") String drugId) throws IOException {
        try {
            InputStream in = getClass().getResourceAsStream("/images/" + drugId + ".png");
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoSuchDrugIdException(e, "https://nedrug.mfds.go.kr/pbp/CCBBB01/getItemDetail?itemSeq=" + drugId);
        }
    }
}
