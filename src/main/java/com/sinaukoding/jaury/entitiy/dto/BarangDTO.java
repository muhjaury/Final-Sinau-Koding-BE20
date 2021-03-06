package com.sinaukoding.jaury.entitiy.dto;

import com.sinaukoding.jaury.entitiy.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDTO {
    private Integer idBarang;
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private Supplier supplier;
}
