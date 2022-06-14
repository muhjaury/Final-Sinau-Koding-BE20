package com.sinaukoding.jaury.controller;

import com.sinaukoding.jaury.entitiy.dto.custom.Pembeli.PembeliCustomDTO;
import com.sinaukoding.jaury.response.Response;
import com.sinaukoding.jaury.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @PostMapping
    public Response createPembeli(@RequestBody PembeliCustomDTO body){
        return new Response(pembeliService.createPembeli(body),"Pembeli Created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectPembeli(){
        return new Response(pembeliService.selectPembeli(),"Show all pembeli !", pembeliService.countPembeli(null),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updatePembeli(@RequestBody PembeliCustomDTO data, @PathVariable Integer id){
        return new Response(pembeliService.updatePembeli(data, id),"Pembeli updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deletePembeliById(@PathVariable Integer id){
        if(pembeliService.deletePembeliById(id)) {
            return new Response(null,"Pembeli deleted !", HttpStatus.OK);
        }else{
            return new Response(null,"Pembeli fail to delete !", HttpStatus.OK);
        }
    }
}