package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
