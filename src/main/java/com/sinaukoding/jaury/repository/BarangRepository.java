package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, Integer> {
    Integer countByNamaBarangContaining(String string);
}
