package com.sinaukoding.jaury.entitiy.mapping;

import com.sinaukoding.jaury.entitiy.Barang;
import com.sinaukoding.jaury.entitiy.dto.BarangDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangCustomWithIdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapping {
    BarangMapping INSTANCE = Mappers.getMapper(BarangMapping.class);
    Barang toEntity(BarangDTO barangDTO);
    Barang toEntity(BarangCustomDTO data);

    BarangDTO toDTO(Barang barang);
    BarangCustomDTO toCustomDTO(Barang barang);

    BarangCustomWithIdDTO toCutomWithIdDTO(Barang barang);
    List<BarangCustomDTO> toCustomDTOList(List<Barang> barang);
    List<BarangCustomWithIdDTO> toCustomWithIdDTOList(List<Barang> barang);


}
