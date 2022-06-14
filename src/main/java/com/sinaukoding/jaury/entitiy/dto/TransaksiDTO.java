package com.sinaukoding.jaury.entitiy.dto;

import com.sinaukoding.jaury.entitiy.Barang;
import com.sinaukoding.jaury.entitiy.Pembeli;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private Barang barang;
    private Pembeli pembeli;
    private Date tglTransaksi;
    private String keterangan;
}
