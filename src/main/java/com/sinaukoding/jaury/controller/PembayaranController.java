package com.sinaukoding.jaury.controller;

import com.sinaukoding.jaury.entitiy.dto.PembayaranDTO;
import com.sinaukoding.jaury.response.Response;
import com.sinaukoding.jaury.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @PostMapping
    public Response createPembayaran(@RequestBody PembayaranDTO data){
        return new Response(pembayaranService.createPembayaran(data), "Pembayaran created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectBarang(){
        return new Response(pembayaranService.selectPembayaran(),"Show all pembayaran !", pembayaranService.countPembayaran(null),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updatePembayaran(@RequestBody PembayaranDTO data, @PathVariable Integer id){
        return new Response(pembayaranService.updatePembayaranById(data, id),"Pembayaran updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deletePembayaranById(@PathVariable Integer id){
        if(pembayaranService.deletePembayaranById(id)) {
            return new Response(null,"Pembayaran deleted !", HttpStatus.OK);
        }else{
            return new Response(null,"Pembayaran fail to delete !", HttpStatus.OK);
        }
    }

}
