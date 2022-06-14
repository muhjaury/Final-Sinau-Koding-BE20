package com.sinaukoding.jaury.controller;

import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangCustomDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Barang.BarangSupplierCustomDTO;
import com.sinaukoding.jaury.response.Response;
import com.sinaukoding.jaury.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @PostMapping
    public Response createBarang(@RequestBody BarangCustomDTO data){
        return new Response(barangService.createBarang(data), "Barang created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectBarang(){
        return new Response(barangService.selectBarang(),"Show all barang !", barangService.countBarang(null),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateBarang(@RequestBody BarangSupplierCustomDTO data, @PathVariable Integer id){
        return new Response(barangService.updateBarangById(data, id),"Barang updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteBarangById(@PathVariable Integer id){
        if(barangService.deleteBarangById(id)) {
            return new Response(null,"Data deleted !", HttpStatus.OK);
        }else{
            return new Response(null,"Data fail to delete !", HttpStatus.OK);
        }
    }
}