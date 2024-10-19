package com.vaxi.spring_boot_microservice_2_compra.controller;

import com.vaxi.spring_boot_microservice_2_compra.model.Compra;
import com.vaxi.spring_boot_microservice_2_compra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        return new ResponseEntity<>(compraService.saveCompra(compra),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id){
        compraService.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasForUser(@PathVariable Long userId){
        return ResponseEntity.ok(compraService.findAllComprasOfUser(userId));
    }
}