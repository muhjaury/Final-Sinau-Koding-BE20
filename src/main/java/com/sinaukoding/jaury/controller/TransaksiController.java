package com.sinaukoding.jaury.controller;

import com.sinaukoding.jaury.entitiy.dto.TransaksiDTO;
import com.sinaukoding.jaury.entitiy.dto.custom.Transaksi.TransaksiCustomDTO;
import com.sinaukoding.jaury.response.Response;
import com.sinaukoding.jaury.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @PostMapping
    public Response createTransaksi(@RequestBody TransaksiCustomDTO data){
        return new Response(transaksiService.createTransaksi(data), "Transaksi created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectTransaksi(){
        return new Response(transaksiService.selectTransaksi(),"Show all Transaksi !", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateTransaksi(@RequestBody TransaksiCustomDTO data, @PathVariable Integer id){
        return new Response(transaksiService.updateTransaksiById(data, id),"Transaksi updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteTransaksiById(@PathVariable Integer id){
        if(transaksiService.deleteTransaksiById(id)) {
            return new Response(null,"Transaksi deleted !", HttpStatus.OK);
        }else{
            return new Response(null,"Transaksi fail to delete !", HttpStatus.OK);
        }
    }
}
