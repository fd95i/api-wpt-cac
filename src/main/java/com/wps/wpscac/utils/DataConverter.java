package com.wps.wpscac.utils;

public interface DataConverter<ENTITY,DTO> {
    public DTO toDTO();
    public ENTITY toEntity();
}
