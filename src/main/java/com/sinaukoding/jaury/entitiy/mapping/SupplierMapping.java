package com.sinaukoding.jaury.entitiy.mapping;

import com.sinaukoding.jaury.entitiy.Supplier;
import com.sinaukoding.jaury.entitiy.dto.SupplierDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Supplier.SupplierWithIdCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapping {
    SupplierMapping INSTANCE = Mappers.getMapper(SupplierMapping.class);
    Supplier toEntity(SupplierDTO supplierDTO);
    SupplierDTO toDTO(Supplier supplier);

    SupplierWithIdCustomDTO toWithIdCustomDTO(Supplier supplier);
    List<Supplier> toSupplierList(List<SupplierDTO> dtoList);
    List<SupplierDTO> toSupplierDTOList(List<Supplier> supplierList);
    List<SupplierWithIdCustomDTO> toSupplierCustomWithIdDTOList(List<Supplier> supplierList);
}
