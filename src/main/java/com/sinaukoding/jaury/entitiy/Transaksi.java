package com.sinaukoding.jaury.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;

    @JsonIgnoreProperties(value = {"transaksiPembayaranList","handler","hibernateLazyInitializer"}
            ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;

    @JsonIgnoreProperties(value = {"transaksiBarangList","handler","hibernateLazyInitializer"}
            ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @JsonIgnoreProperties(value = {"transaksiPembeliList","handler","hibernateLazyInitializer"}
            ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_transaksi")
    private Date tglTransaksi;

    @Column(name = "keterangan")
    private String keterangan;
}
