package com.sinaukoding.jaury.entitiy.mapping;

import com.sinaukoding.jaury.entitiy.Pembayaran;
import com.sinaukoding.jaury.entitiy.dto.PembayaranDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Pembayaran.PembayaranWithIdCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PembayaranMapping {
    PembayaranMapping INSTANCE = Mappers.getMapper(PembayaranMapping.class);
    Pembayaran toEntity(PembayaranDTO pembayaranDTO);
    PembayaranWithIdCustomDTO toWithIdCustomDTO(Pembayaran pembayaran);
}
