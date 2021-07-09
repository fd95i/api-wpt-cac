package com.wps.wpscac.location.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @Column(name = "location_id")
    private Integer locationId;
    private String street;
    private String number;
    private String neighboor;
    @Column(name = "zip_code")
    private String zipCode;
    private String pb;
}
