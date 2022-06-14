package com.sinaukoding.jaury.service;

import com.sinaukoding.jaury.entitiy.Pembayaran;
import com.sinaukoding.jaury.entitiy.dto.PembayaranDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Pembayaran.PembayaranWithIdCustomDTO;
import com.sinaukoding.jaury.entitiy.mapping.PembayaranMapping;
import com.sinaukoding.jaury.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service

public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    //Create
    public PembayaranWithIdCustomDTO createPembayaran(PembayaranDTO data){
        Pembayaran pembayaran = PembayaranMapping.INSTANCE.toEntity(data);
        return PembayaranMapping.INSTANCE.toWithIdCustomDTO(pembayaranRepository.save(pembayaran));
    }

    //Select
    public List<Pembayaran> selectPembayaran(){
        return pembayaranRepository.findAll();
    }

    //Update
    public PembayaranWithIdCustomDTO updatePembayaranById(PembayaranDTO data, Integer id){
        Pembayaran reference = pembayaranRepository.findById(id).get();
        reference.setTglBayar(data.getTglBayar()!=null?data.getTglBayar():reference.getTglBayar());
        reference.setTotal(data.getTotal()!=null?data.getTotal():reference.getTotal());
        return PembayaranMapping.INSTANCE.toWithIdCustomDTO(pembayaranRepository.save(reference));
    }

    //Delete
    public Boolean deletePembayaranById(Integer id){
        Pembayaran reference = pembayaranRepository.findById(id).orElse(null);
        if(reference != null){
            pembayaranRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countPembayaran(Date date){
        if(date != null){
            return pembayaranRepository.countByTglBayar(date);
        }
        return (int) pembayaranRepository.count();
    }
}
