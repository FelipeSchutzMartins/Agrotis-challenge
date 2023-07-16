package com.agrotis.property.controller;

import com.agrotis.exceptions.AgrotisException;
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
    public PropertyResponse show(@PathVariable("id") Long id) throws AgrotisException {
        return this.propertyService.show(id);
    }

    @GetMapping("/findAll")
    public List<PropertyResponse> findAll() {
        return this.propertyService.findAll();
    }

    @PostMapping("/create")
    public PropertyResponse create(@Valid @RequestBody CreatePropertyRequest request) throws AgrotisException {
        return this.propertyService.create(request);
    }

    @PutMapping("/update")
    public PropertyResponse update(@Valid @RequestBody UpdatePropertyRequest request) throws AgrotisException {
        return this.propertyService.update(request);
    }

    @DeleteMapping("/delete/{ids}")
    public void delete(@PathVariable("ids") List<Long> ids) throws AgrotisException {
        this.propertyService.delete(ids);
    }

}
