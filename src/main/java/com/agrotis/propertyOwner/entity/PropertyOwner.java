package com.agrotis.propertyOwner.entity;

import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.property.entity.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class PropertyOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String observations;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Property property;

    @ManyToOne
    private Laboratory laboratory;

}
