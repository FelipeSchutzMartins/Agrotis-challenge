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
    public PropertyOwnerResponse find(@PathVariable("id") Long id) throws AgrotisException {
        return propertyOwnerService.show(id);
    }

    @GetMapping("/findAll")
    public List<PropertyOwnerResponse> findAll() {
        return propertyOwnerService.findAll();
    }

    @PutMapping("/create")
    public PropertyOwnerResponse create(@Valid @RequestBody CreatePropertyOwnerRequest request) throws AgrotisException {
        return propertyOwnerService.create(request);
    }

    @PostMapping("/update")
    public PropertyOwnerResponse update(@Valid @RequestBody UpdatePropertyOwnerRequest request) throws AgrotisException {
        return propertyOwnerService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("ids") List<Long> ids) throws AgrotisException {
        propertyOwnerService.delete(ids);
    }

}
