package com.agrotis.laboratory.service;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.laboratory.dtos.request.CreateLaboratoryRequest;
import com.agrotis.laboratory.dtos.request.UpdateLaboratoryRequest;
import com.agrotis.laboratory.dtos.response.LaboratoryResponse;
import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.laboratory.mappers.LaboratoryMapper;
import com.agrotis.laboratory.repository.LaboratoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LaboratoryService {

    private LaboratoryRepository laboratoryRepository;


    public Laboratory findById(Long id) throws AgrotisException {
        return this.laboratoryRepository.findById(id)
                .orElseThrow(() -> new AgrotisException("Laboratório {" + id + "} não encontrado"));
    }

    public LaboratoryResponse show(Long id) throws AgrotisException {
        return LaboratoryMapper.buildResponse(findById(id));
    }

    @Transactional
    public LaboratoryResponse create(CreateLaboratoryRequest request) {
        Laboratory laboratory = LaboratoryMapper.buildLaboratory(request);
        return LaboratoryMapper.buildResponse(this.laboratoryRepository.save(laboratory));
    }

    @Transactional
    public LaboratoryResponse update(UpdateLaboratoryRequest request) throws AgrotisException {
        Laboratory laboratory = findById(request.getId());
        laboratory.setName(request.getName());
        return LaboratoryMapper.buildResponse(this.laboratoryRepository.save(laboratory));
    }

    @Transactional
    public void delete(List<Long> ids) throws AgrotisException {
        for(Long id : ids) {
            delete(id);
        }
    }

    public void delete(Long id) throws AgrotisException {
        var laboratory = findById(id);
        this.laboratoryRepository.delete(laboratory);
    }

    public List<LaboratoryResponse> findAll() {
        return this.laboratoryRepository.findAll().stream()
                .map(LaboratoryMapper::buildResponse)
                .collect(Collectors.toList());
    }
}
