package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.repository.DrugInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrugInfoService {
    private final DrugInfoRepository drugInfoRepository;
    public DrugInfo findByDrugId(Long drugId){
        Optional<DrugInfo> find = drugInfoRepository.findByDrugId(drugId);
        if(find == null || find.isEmpty())
            return null;
        return find.get();
    }
    public List<DrugInfo> findByDrugNameContains(String drugName){
        return drugInfoRepository.findByDrugNameContains(drugName);
    }
}
