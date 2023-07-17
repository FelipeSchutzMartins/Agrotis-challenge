package com.agrotis.property.service;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.property.dtos.request.CreatePropertyRequest;
import com.agrotis.property.dtos.request.UpdatePropertyRequest;
import com.agrotis.property.dtos.response.PropertyResponse;
import com.agrotis.property.entity.Property;
import com.agrotis.property.mappers.PropertyMapper;
import com.agrotis.property.repository.PropertyRepository;
import com.agrotis.utils.RegexPatternsUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public Property findById(Long id) throws AgrotisException {
        return this.propertyRepository.findById(id)
                .orElseThrow(() -> new AgrotisException("Propriedade {" + id + "} não encontrada"));
    }

    public PropertyResponse show(Long id) throws AgrotisException {
        return PropertyMapper.buildResponse(findById(id));
    }

    public List<PropertyResponse> findAll() {
        return this.propertyRepository.findAll().stream()
                .map(PropertyMapper::buildResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public PropertyResponse create(CreatePropertyRequest request) throws AgrotisException {
        Property property = PropertyMapper.buildProperty(request);
        validateProperty(property);
        return PropertyMapper.buildResponse(this.propertyRepository.save(property));
    }

    @Transactional
    public PropertyResponse update(UpdatePropertyRequest request) throws AgrotisException {
        Property property = findById(request.getId());
        property.setName(request.getName());
        property.setCnpj(request.getCnpj());
        validateProperty(property);
        return PropertyMapper.buildResponse(this.propertyRepository.save(property));
    }

    @Transactional
    public void delete(List<Long> ids) throws AgrotisException {
        for(Long id : ids) {
            delete(id);
        }
    }

    public void delete(Long id) throws AgrotisException {
        var property = findById(id);
        this.propertyRepository.delete(property);
    }

    private void validateProperty(Property property) throws AgrotisException {
        if (RegexPatternsUtils.containsNonNumeric(property.getCnpj())) {
            throw new AgrotisException("CNPJ inválido");
        }
    }
}
