package com.sinaukoding.jaury.entitiy.dto.custom.Barang;

import com.sinaukoding.jaury.entitiy.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangSupplierCustomDTO {
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private Supplier supplier;
}
