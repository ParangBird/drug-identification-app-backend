package sotree.dia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sotree.dia.repository.DrugShapeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugShapeService {
    private final DrugShapeRepository drugShapeRepository;

    public List<Long> findDrugByShape(String letter, String form, String color) {
        return drugShapeRepository.findAllByDrugShape(letter, form, color);
    }

}
