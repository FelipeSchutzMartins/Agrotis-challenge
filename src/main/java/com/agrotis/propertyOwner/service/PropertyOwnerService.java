package com.agrotis.propertyOwner.service;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.laboratory.service.LaboratoryService;
import com.agrotis.property.entity.Property;
import com.agrotis.property.service.PropertyService;
import com.agrotis.propertyOwner.dtos.request.CreatePropertyOwnerRequest;
import com.agrotis.propertyOwner.dtos.request.UpdatePropertyOwnerRequest;
import com.agrotis.propertyOwner.dtos.response.PropertyOwnerResponse;
import com.agrotis.propertyOwner.entity.PropertyOwner;
import com.agrotis.propertyOwner.mappers.PropertyOwnerMapper;
import com.agrotis.propertyOwner.repository.PropertyOwnerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PropertyOwnerService {

    private PropertyOwnerRepository propertyOwnerRepository;
    private LaboratoryService laboratoryService;
    private PropertyService propertyService;

    public PropertyOwner findById(Long id) throws AgrotisException {
        return this.propertyOwnerRepository.findById(id)
                .orElseThrow(() -> new AgrotisException("Proprietário {" + id + "} não encontrado"));
    }
    public PropertyOwnerResponse show(Long id) throws AgrotisException {
        PropertyOwner propertyOwner = findById(id);
        return PropertyOwnerMapper.buildResponse(propertyOwner);
    }

    public List<PropertyOwnerResponse> findAll() {
        return this.propertyOwnerRepository.findAll().stream()
                .map(PropertyOwnerMapper::buildResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public PropertyOwnerResponse create(CreatePropertyOwnerRequest request) throws AgrotisException {
        Property property = this.propertyService.findById(request.getPropertyId());
        Laboratory laboratory = this.laboratoryService.findById(request.getLaboratoryId());
        PropertyOwner propertyOwner = PropertyOwnerMapper.buildPropertyOwner(request, property, laboratory);
        validatePropertyOwner(propertyOwner);
        return PropertyOwnerMapper.buildResponse(this.propertyOwnerRepository.save(propertyOwner));
    }

    @Transactional
    public PropertyOwnerResponse update(UpdatePropertyOwnerRequest request) throws AgrotisException {
        PropertyOwner propertyOwner = findById(request.getId());
        updatePropertyOwner(propertyOwner, request);
        validatePropertyOwner(propertyOwner);
        return PropertyOwnerMapper.buildResponse(this.propertyOwnerRepository.save(propertyOwner));
    }

    @Transactional
    public void delete(List<Long> ids) throws AgrotisException {
        for(Long id : ids) {
            delete(id);
        }
    }

    public void delete(Long id) throws AgrotisException {
        var property = findById(id);
        this.propertyOwnerRepository.delete(property);
    }

    private void validatePropertyOwner(PropertyOwner propertyOwner) throws AgrotisException {
        if (propertyOwner.getStartDate().isAfter(propertyOwner.getEndDate())) {
            throw new AgrotisException("Data inicial deve ser menor do que a data final");
        }
    }

    private void updatePropertyOwner(PropertyOwner propertyOwner, UpdatePropertyOwnerRequest request) throws AgrotisException {
        Property property = this.propertyService.findById(request.getPropertyId());
        Laboratory laboratory = this.laboratoryService.findById(request.getLaboratoryId());
        propertyOwner.setName(request.getName());
        propertyOwner.setObservations(request.getObservations());
        propertyOwner.setStartDate(request.getStartDate());
        propertyOwner.setEndDate(request.getEndDate());
        propertyOwner.setProperty(property);
        propertyOwner.setLaboratory(laboratory);
    }
}
