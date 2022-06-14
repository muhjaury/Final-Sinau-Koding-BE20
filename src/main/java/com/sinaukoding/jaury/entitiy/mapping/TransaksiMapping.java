package com.sinaukoding.jaury.entitiy.mapping;

import com.sinaukoding.jaury.entitiy.Transaksi;
import com.sinaukoding.jaury.entitiy.dto.TransaksiDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Transaksi.TransaksiCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Transaksi.TransaksiWithIdCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapping {
    TransaksiMapping INSTANCE = Mappers.getMapper(TransaksiMapping.class);
    Transaksi toEntity(TransaksiDTO dto);
    Transaksi toEntityCustom(TransaksiCustomDTO dto);
    TransaksiDTO toDTO(Transaksi transaksi);
    TransaksiCustomDTO toCustomDTO(Transaksi transaksi);
    TransaksiWithIdCustomDTO toWithIdCustomDTO(Transaksi transaksi);
    List<Transaksi> toTransaksiList(List<TransaksiDTO> dto);
    List<TransaksiDTO> toTransaksiDTOList(List<Transaksi> list);
    List<TransaksiCustomDTO> toTransaksiCustomDTOList(List<Transaksi> list);
    List<TransaksiWithIdCustomDTO> toTransaksiWithIdCustomDTOList(List<Transaksi> list);
}