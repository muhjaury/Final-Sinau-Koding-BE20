package com.sinaukoding.jaury.service;

import com.sinaukoding.jaury.entitiy.Supplier;
import com.sinaukoding.jaury.entitiy.dto.SupplierDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Supplier.SupplierWithIdCustomDTO;
import com.sinaukoding.jaury.entitiy.mapping.SupplierMapping;
import com.sinaukoding.jaury.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    //Create
    public SupplierDTO createSupplier(SupplierDTO data){
        Supplier supplier = SupplierMapping.INSTANCE.toEntity(data);
        return SupplierMapping.INSTANCE.toDTO(supplierRepository.save(supplier));
    }

    //Read
    public List<SupplierWithIdCustomDTO> selectSupplier(){
        return SupplierMapping.INSTANCE.toSupplierCustomWithIdDTOList(supplierRepository.findAll());
    }

    //Update
    public SupplierWithIdCustomDTO updateSupplierById(SupplierDTO data, Integer id){
        Supplier reference = supplierRepository.findById(id).get();
        reference.setNamaSupplier(data.getNamaSupplier()!=null?data.getNamaSupplier():reference.getNamaSupplier());
        reference.setNoTelp(data.getNoTelp()!=null?data.getNoTelp():reference.getNoTelp());
        reference.setAlamat(data.getAlamat()!=null?data.getAlamat():reference.getAlamat());
        return SupplierMapping.INSTANCE.toWithIdCustomDTO(supplierRepository.save(reference));
    }

    //Delete
    public Boolean deleteSupplierById(Integer id){
        Supplier reference = supplierRepository.findById(id).orElse(null);
        if(reference != null){
            supplierRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countSupplier(String string){
        if(string != null){
            return supplierRepository.countByNamaSupplierContaining(string);
        }
        return (int) supplierRepository.count();
    }
}
