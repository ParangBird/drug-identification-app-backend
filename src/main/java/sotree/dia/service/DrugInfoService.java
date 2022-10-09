package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.repository.DrugInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugInfoService {
    private final DrugInfoRepository drugInfoRepository;
    public DrugInfo findByDrugId(Long drugId){
        return drugInfoRepository.findByDrugId(drugId).get();
    }
    public List<DrugInfo> findByDrugNameContains(String drugName){
        return drugInfoRepository.findByDrugNameContains(drugName);
    }
}
