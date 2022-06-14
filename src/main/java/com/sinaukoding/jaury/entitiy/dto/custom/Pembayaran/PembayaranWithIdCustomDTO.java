package com.sinaukoding.jaury.entitiy.dto.custom.Pembayaran;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PembayaranWithIdCustomDTO {
    private Integer idPembayaran;
    private Date tglBayar;
    private Double total;
}
