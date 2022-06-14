package com.sinaukoding.jaury.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pembeli")
@Getter
@Setter
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembeli")
    private Integer idPembeli;

    @Column(name = "nama_pembeli")
    private String namaPembeli;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "alamat")
    private String alamat;
}
