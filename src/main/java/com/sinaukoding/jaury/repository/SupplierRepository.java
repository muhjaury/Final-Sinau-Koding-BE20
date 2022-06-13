package com.sinaukoding.jaury.repository;

import com.sinaukoding.jaury.entitiy.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
 Integer countByNamaSupplierContaining(String string);
}
