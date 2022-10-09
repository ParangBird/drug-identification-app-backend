package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sotree.dia.domain.entity.DrugInfo;
import sotree.dia.repository.DrugInfoRepository;

@Service
@RequiredArgsConstructor
public class DrugInfoService {
    private final DrugInfoRepository drugInfoRepository;
    public DrugInfo findBy(Long id){
        return drugInfoRepository.findByDrugId(id).get();
    }
}
