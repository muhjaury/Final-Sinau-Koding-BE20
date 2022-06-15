package com.sinaukoding.jaury.service;

import com.sinaukoding.jaury.entitiy.Barang;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangWithIdCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangUpdateCustomDTO;
import com.sinaukoding.jaury.entitiy.mapping.BarangMapping;
import com.sinaukoding.jaury.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository barangRepository;

    //Create
    public BarangWithIdCustomDTO createBarang(BarangCustomDTO data){
        Barang barang = BarangMapping.INSTANCE.toEntity(data);
        return BarangMapping.INSTANCE.toCutomWithIdDTO(barangRepository.save(barang));
    }

    //Read
    public List<BarangWithIdCustomDTO> selectBarang(){
        return BarangMapping.INSTANCE.toCustomWithIdDTOList(barangRepository.findAll());
    }

    public List<BarangWithIdCustomDTO> selectBarangByNamaBarangAndSupplier(String string, Integer integer){
        return BarangMapping.INSTANCE.toCustomWithIdDTOList(barangRepository.findByNamaBarangContainingAndSupplier(string, integer));
    }

    //Update
    public BarangWithIdCustomDTO updateBarangById(BarangUpdateCustomDTO data, Integer id){
        Barang reference = barangRepository.findById(id).get();
        reference.setNamaBarang(data.getNamaBarang()!=null?data.getNamaBarang():reference.getNamaBarang());
        reference.setHarga(data.getHarga()!=null?data.getHarga():reference.getHarga());
        reference.setStok(data.getStok()!=null?data.getStok():reference.getStok());
        reference.setSupplier(data.getSupplier()!=null?data.getSupplier():reference.getSupplier());
        return BarangMapping.INSTANCE.toCutomWithIdDTO(barangRepository.save(reference));
    }

    //Delete
    public Boolean deleteBarangById(Integer id){
        Barang reference = barangRepository.findById(id).orElse(null);
        if(reference != null){
            barangRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countBarang(String string){
        if(string != null){
            return barangRepository.countByNamaBarangContaining(string);
        }
        return (int) barangRepository.count();
    }

}
