package com.sinaukoding.jaury.entitiy.dto.custom.Barang;

import com.sinaukoding.jaury.entitiy.dto.custom.Supplier.SupplierOnlyIdCustomDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangWithIdCustomDTO {
    private Integer idBarang;
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private SupplierOnlyIdCustomDTO supplier;
}
