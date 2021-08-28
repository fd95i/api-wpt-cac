package com.wps.wpscac.location.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id_sucursal")
    private Integer locationId;
    @JsonProperty("calle")
    private String street;
    @JsonProperty("altura")
    private String number;
    @JsonProperty("barrio")
    private String neighboor;
    @JsonProperty("ciudad")
    private String state;
    @Column(name = "zip_code")
    @JsonProperty("codigoPostal")
    private String zipCode;
    @JsonProperty("googleMaps")
    private String pb;
}
