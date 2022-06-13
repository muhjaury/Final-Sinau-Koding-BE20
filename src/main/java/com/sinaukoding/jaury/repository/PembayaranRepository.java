package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {
    Integer countByTglBayar (Date date);
}
