package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarangRepository extends JpaRepository<Barang, Integer> {
    Integer countByNamaBarangContaining(String string);
    @Query(value = "SELECT * FROM barang WHERE nama_barang LIKE %?1% AND id_supplier = ?2", nativeQuery = true)
    List<Barang> findByNamaBarangContainingAndSupplier(String string, Integer integer);
}
