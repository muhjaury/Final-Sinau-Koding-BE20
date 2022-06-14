package com.sinaukoding.jaury.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pembayaran")
@Getter
@Setter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private Integer idPembayaran;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_bayar")
    private Date tglBayar;

    @Column(name = "total")
    private Double total;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_transaksi")
//    private Transaksi transaksiPembayaran;

    @OneToMany(mappedBy = "pembayaran", fetch = FetchType.EAGER)
    private List<Transaksi> transaksiPembayaranList = new ArrayList<>();
}
