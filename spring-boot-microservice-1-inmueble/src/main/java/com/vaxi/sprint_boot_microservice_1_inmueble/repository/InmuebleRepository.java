package com.vaxi.sprint_boot_microservice_1_inmueble.repository;

import com.vaxi.sprint_boot_microservice_1_inmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble,Long> {


}