package com.agrotis.laboratory.controller;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.laboratory.dtos.request.CreateLaboratoryRequest;
import com.agrotis.laboratory.dtos.request.UpdateLaboratoryRequest;
import com.agrotis.laboratory.dtos.response.LaboratoryResponse;
import com.agrotis.laboratory.service.LaboratoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

    private LaboratoryService laboratoryService;

    @GetMapping("/show/{id}")
    public LaboratoryResponse find(@PathVariable("id") Long id) throws AgrotisException {
        return laboratoryService.show(id);
    }

    @GetMapping("/findAll")
    public List<LaboratoryResponse> findAll() {
        return laboratoryService.findAll();
    }

    @PutMapping("/create")
    public LaboratoryResponse create(@Valid @RequestBody CreateLaboratoryRequest request) {
        return laboratoryService.create(request);
    }

    @PostMapping("/update")
    public LaboratoryResponse update(@Valid @RequestBody UpdateLaboratoryRequest request) throws AgrotisException {
        return laboratoryService.update(request);
    }

    @DeleteMapping("/delete/{ids}")
    public void delete(@PathVariable("ids") List<Long> ids) throws AgrotisException {
        laboratoryService.delete(ids);
    }

}
