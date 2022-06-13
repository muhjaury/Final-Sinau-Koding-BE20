package com.sinaukoding.jaury.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barang")
@Getter
@Setter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private int idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga")
    private double harga;

    @Column(name = "stok")
    private int stok;

    @JsonIgnoreProperties(value = {"barangSupplierList","handler","hibernateLazyInitializer"}
            ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    @OneToMany(mappedBy = "barang", fetch = FetchType.EAGER)
    private List<Transaksi> transaksiBarangList = new ArrayList<>();
}
