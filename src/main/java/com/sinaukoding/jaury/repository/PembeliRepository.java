package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PembeliRepository extends JpaRepository<Pembeli, Integer>{
    Integer countByNamaPembeliContaining(String string);
    List<Pembeli> findByNamaPembeliContaining(String string);
}
