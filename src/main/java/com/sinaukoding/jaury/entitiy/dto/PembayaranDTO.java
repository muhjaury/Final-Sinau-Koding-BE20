package com.sinaukoding.jaury.entitiy.dto;

import com.sinaukoding.jaury.entitiy.Transaksi;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PembayaranDTO {
    private Date tglBayar;
    private Double total;
}
