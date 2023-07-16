package com.agrotis.property.controller;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.laboratory.dtos.request.CreateLaboratoryRequest;
import com.agrotis.laboratory.dtos.request.UpdateLaboratoryRequest;
import com.agrotis.property.dtos.request.CreatePropertyRequest;
import com.agrotis.property.dtos.request.UpdatePropertyRequest;
import com.agrotis.property.dtos.response.PropertyResponse;
import com.agrotis.property.service.PropertyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/property")
@RestController
public class PropertyController {

    private PropertyService propertyService;

    @GetMapping("/show/{id}")
    public PropertyResponse find(@PathVariable("id") Long id) throws AgrotisException {
        return propertyService.show(id);
    }

    @GetMapping("/findAll")
    public List<PropertyResponse> findAll() {
        return propertyService.findAll();
    }

    @PutMapping("/create")
    public PropertyResponse create(@Valid @RequestBody CreatePropertyRequest request) throws AgrotisException {
        return propertyService.create(request);
    }

    @PostMapping("/update")
    public PropertyResponse update(@Valid @RequestBody UpdatePropertyRequest request) throws AgrotisException {
        return propertyService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("ids") List<Long> ids) throws AgrotisException {
        propertyService.delete(ids);
    }

}
