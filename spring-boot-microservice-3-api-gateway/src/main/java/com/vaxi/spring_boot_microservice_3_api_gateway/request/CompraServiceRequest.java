package com.vaxi.spring_boot_microservice_3_api_gateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value="compra-service",
        path="/api/compra",
        //url="${compras.service.url}",
        configuration = FeignConfiguration.class
)
public interface CompraServiceRequest {



    @PostMapping
    Object saveCompra(@RequestBody Object compra);

    @GetMapping("{userId}")
    List<Object> findAllComprasOfUser(@PathVariable("userId") Long userId);
}
