package com.sinaukoding.jaury.service;

import com.sinaukoding.jaury.entitiy.Pembeli;
import com.sinaukoding.jaury.entitiy.dto.PembeliDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Pembeli.PembeliCustomDTO;
import com.sinaukoding.jaury.entitiy.mapping.PembeliMapping;
import com.sinaukoding.jaury.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    //Create
    public PembeliDTO createPembeli(PembeliCustomDTO data){
        Pembeli pembeli = PembeliMapping.INSTANCE.toCustomEntity(data);
        return PembeliMapping.INSTANCE.toDTO(pembeliRepository.save(pembeli));
    }

    //Select
    public List<PembeliDTO> selectPembeli(){
        return PembeliMapping.INSTANCE.toDTOList(pembeliRepository.findAll());
    }
    public List<PembeliDTO> selectPembeliByNamaPembeli(String string){
        return PembeliMapping.INSTANCE.toDTOList(pembeliRepository.findByNamaPembeliContaining(string));
    }

    //Update
    public PembeliDTO updatePembeli(PembeliCustomDTO data, Integer id){
        Pembeli reference = pembeliRepository.findById(id).get();
        reference.setNamaPembeli(data.getNamaPembeli()!=null?data.getNamaPembeli():reference.getNamaPembeli());
        reference.setAlamat(data.getAlamat()!=null?data.getAlamat():reference.getAlamat());
        reference.setNoTelp(data.getNoTelp()!=null?data.getNoTelp():reference.getNoTelp());
        return PembeliMapping.INSTANCE.toDTO(pembeliRepository.save(reference));
    }

    //Delete
    public Boolean deletePembeliById(Integer id){
        Pembeli reference = pembeliRepository.findById(id).orElse(null);
        if(reference != null){
            pembeliRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countPembeli(String string){
        if(string != null){
            return pembeliRepository.countByNamaPembeliContaining(string);
        }
        return (int) pembeliRepository.count();
    }
}
