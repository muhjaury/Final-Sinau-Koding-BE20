package com.sinaukoding.jaury.entitiy.dto.custom.Transaksi;

import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangOnlyIdCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Pembeli.PembeliOnlyIdCustomDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiCustomDTO {
    private BarangOnlyIdCustomDTO barang;
    private PembeliOnlyIdCustomDTO pembeli;
    private Date tglTransaksi;
    private String keterangan;
}
