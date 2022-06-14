package com.sinaukoding.jaury.entitiy.mapping;

import com.sinaukoding.jaury.entitiy.Pembeli;
import com.sinaukoding.jaury.entitiy.dto.PembeliDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Pembeli.PembeliCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapping {
    PembeliMapping INSTANCE = Mappers.getMapper(PembeliMapping.class);

    Pembeli toEntity(PembeliDTO data);
    Pembeli toCustomEntity(PembeliCustomDTO data);
    PembeliDTO toDTO(Pembeli pembeli);
    PembeliCustomDTO toCustomDTO(Pembeli pembeli);
    List<PembeliDTO> toDTOList(List<Pembeli> data);
    List<PembeliCustomDTO> toCustomDTOList(List<Pembeli> data);

}
