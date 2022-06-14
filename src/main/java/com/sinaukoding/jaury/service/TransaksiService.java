package com.sinaukoding.jaury.service;

import com.sinaukoding.jaury.entitiy.Transaksi;
import com.sinaukoding.jaury.entitiy.dto.TransaksiDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Transaksi.TransaksiCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Transaksi.TransaksiWithIdCustomDTO;
import com.sinaukoding.jaury.entitiy.mapping.TransaksiMapping;
import com.sinaukoding.jaury.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    //Create
    public TransaksiWithIdCustomDTO createTransaksi(TransaksiCustomDTO data){
        Transaksi transaksi = TransaksiMapping.INSTANCE.toEntityCustom(data);
        return TransaksiMapping.INSTANCE.toWithIdCustomDTO(transaksiRepository.save(transaksi));
    }

    //Select
    public List<TransaksiWithIdCustomDTO> selectTransaksi(){
        return TransaksiMapping.INSTANCE.toTransaksiWithIdCustomDTOList(transaksiRepository.findAll());
    }

    //Update
    public TransaksiWithIdCustomDTO updateTransaksiById(TransaksiDTO data, Integer id){
        Transaksi reference = transaksiRepository.findById(id).get();
        reference.setPembayaran(data.getPembayaran()!=null?data.getPembayaran():reference.getPembayaran());
        reference.setBarang(data.getBarang()!=null?data.getBarang():reference.getBarang());
        reference.setPembeli(data.getPembeli()!=null?data.getPembeli():reference.getPembeli());
        reference.setTglTransaksi(data.getTglTransaksi()!=null?data.getTglTransaksi():reference.getTglTransaksi());
        reference.setKeterangan(data.getKeterangan()!=null?data.getKeterangan():reference.getKeterangan());
        return TransaksiMapping.INSTANCE.toWithIdCustomDTO(transaksiRepository.save(reference));
    }

    //Delete
    public Boolean deleteTransaksiById(Integer id){
        Transaksi reference = transaksiRepository.findById(id).orElse(null);
        if(reference != null){
            transaksiRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countTransaksi(Date date){
        if(date != null){
            return transaksiRepository.countByTglTransaksi(date);
        }
        return (int) transaksiRepository.count();
    }
}
