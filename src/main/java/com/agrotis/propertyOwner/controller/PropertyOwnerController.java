package com.agrotis.propertyOwner.controller;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.propertyOwner.dtos.request.CreatePropertyOwnerRequest;
import com.agrotis.propertyOwner.dtos.request.UpdatePropertyOwnerRequest;
import com.agrotis.propertyOwner.dtos.response.PropertyOwnerResponse;
import com.agrotis.propertyOwner.service.PropertyOwnerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/propertyOwner")
@RestController
public class PropertyOwnerController {

    private PropertyOwnerService propertyOwnerService;


    @GetMapping("/show/{id}")
    public PropertyOwnerResponse show(@PathVariable("id") Long id) throws AgrotisException {
        return this.propertyOwnerService.show(id);
    }

    @GetMapping("/findAll")
    public List<PropertyOwnerResponse> findAll() {
        return this.propertyOwnerService.findAll();
    }

    @PostMapping("/create")
    public PropertyOwnerResponse create(@Valid @RequestBody CreatePropertyOwnerRequest request) throws AgrotisException {
        return this.propertyOwnerService.create(request);
    }

    @PutMapping("/update")
    public PropertyOwnerResponse update(@Valid @RequestBody UpdatePropertyOwnerRequest request) throws AgrotisException {
        return this.propertyOwnerService.update(request);
    }

    @DeleteMapping("/delete/{ids}")
    public void delete(@PathVariable("ids") List<Long> ids) throws AgrotisException {
        this.propertyOwnerService.delete(ids);
    }

}
