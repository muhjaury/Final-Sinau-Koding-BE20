package com.sinaukoding.jaury.controller;

import com.sinaukoding.jaury.entitiy.dto.SupplierDTO;
import com.sinaukoding.jaury.response.Response;
import com.sinaukoding.jaury.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Response createSupplier(@RequestBody SupplierDTO body){
        return new Response(supplierService.createSupplier(body), "Supplier created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectSupplier(){
        return new Response(supplierService.selectSupplier(), "Show all supplier !", supplierService.countSupplier(null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateSupplierById(@RequestBody SupplierDTO param, @PathVariable Integer id){
        return new Response(supplierService.updateSupplierById(param, id),"Data updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteSupplierById(@PathVariable Integer id){
        if(supplierService.deleteSupplierById(id)) {
            return new Response(null,"Data deleted !", HttpStatus.OK);
        }else{
            return new Response(null,"Data fail to delete !", HttpStatus.OK);
        }
    }

}
